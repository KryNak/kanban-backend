package com.kanban.controllers

import com.kanban.dtos.requests.CreateBoardRequestDto
import com.kanban.dtos.requests.UpdateBoardRequestDto
import com.kanban.dtos.responses.CreateBoardResponseDto
import com.kanban.dtos.responses.GetBoardsResponseDto
import com.kanban.jooq.Tables.BOARDS
import com.kanban.models.Board
import com.kanban.models.BoardsColumn
import com.kanban.repositories.BoardRepository
import com.kanban.repositories.BoardsColumnRepository
import com.kanban.utils.ColorUtils
import com.kanban.utils.SecurityUtils
import org.jooq.DSLContext
import org.jooq.impl.DSL.asterisk
import org.jooq.impl.DSL.count
import org.modelmapper.ModelMapper
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException
import java.net.URI
import java.util.*
import javax.transaction.Transactional


@RestController
@RequestMapping(path = ["/api"])
class BoardsController(
    val boardRepository: BoardRepository,
    val columnRepository: BoardsColumnRepository,
    val jooq: DSLContext,
    val modelMapper: ModelMapper
) {

    @GetMapping(path = ["/boards"])
    fun getBoards(): ResponseEntity<List<GetBoardsResponseDto>> {

        val userId = SecurityUtils.getUserId()

        val boards = jooq.select(asterisk())
            .from(BOARDS)
            .where(BOARDS.USER_ID.eq(UUID.fromString(userId)))
            .orderBy(BOARDS.POSITION)
            .fetchInto(BOARDS)
            .map { modelMapper.map(it, GetBoardsResponseDto::class.java) }


        return ResponseEntity.ok(boards)
    }

    @DeleteMapping(path = ["/boards/{id}"])
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    fun deleteBoard(@PathVariable id: UUID) {

        val board = jooq.select(asterisk())
            .from(BOARDS)
            .where(BOARDS.ID.eq(id))
            .fetchOneInto(BOARDS)
            ?: throw ResponseStatusException(HttpStatus.NO_CONTENT)

        boardRepository.deleteById(board.id)

        jooq.update(BOARDS)
            .set(BOARDS.POSITION, BOARDS.POSITION.minus(1))
            .where(BOARDS.POSITION.greaterThan(board.position))
            .execute()

    }

    @GetMapping(path = ["/boards/{id}"])
    fun getBoard(@PathVariable id: UUID): ResponseEntity<Board> {

        val board = boardRepository.findById(id)
            .orElseThrow { ResponseStatusException(HttpStatus.NOT_FOUND) }!!

        board.apply {
            this.columns = this.columns.map { column ->
                column.apply {
                    this.tasks = this.tasks.map { task ->
                        task.apply {
                            this.subtasks = this.subtasks
                                .sortedBy { subtask -> subtask.position }
                                .toMutableList()
                        }
                    }
                        .sortedBy { task -> task.position }
                        .toMutableList()
                }
            }
                .sortedBy { column -> column.position }
                .toMutableList()
        }

        return ResponseEntity.ok(board)
    }

    @PostMapping(path = ["/boards"])
    fun createBoard(@RequestBody createBoardRequest: CreateBoardRequestDto): ResponseEntity<CreateBoardResponseDto> {

        val count = jooq.select(count())
            .from(BOARDS)
            .fetchOneInto(Int::class.java)
            ?: throw IllegalStateException("Query should always return a number")

        val boardToSave = modelMapper.map(createBoardRequest, Board::class.java)
        boardToSave.position = count
        boardToSave.userId = UUID.fromString(SecurityUtils.getUserId())
        boardToSave.columns = boardToSave.columns
            .map { it.apply { color = ColorUtils.getRandom() } }
            .toMutableList()

        val savedBoard = boardRepository.save(boardToSave)

        return ResponseEntity.created(URI.create("/api/boards/${savedBoard.id}"))
            .body(modelMapper.map(savedBoard, CreateBoardResponseDto::class.java))
    }

    @Transactional
    @PutMapping(path = ["/boards/{id}"])
    fun updateBoard(
        @RequestBody updateBoardRequestDto: UpdateBoardRequestDto,
        @PathVariable id: UUID
    ): ResponseEntity<Board> {
        val board = boardRepository.findById(id)
            .orElseThrow { ResponseStatusException(HttpStatus.NOT_FOUND) }!!

        val inputColumnsById = updateBoardRequestDto.columns
            .map { it.apply { this.id = this.id ?: UUID.randomUUID() } }
            .associateBy { it.id }
            .toMutableMap()

        val columnsIntersection = board.columns
            .filter { it.id in inputColumnsById.keys }
            .map {
                val providedBoard = inputColumnsById.remove(it.id)!!
                BoardsColumn().apply {
                    this.id = it.id
                    this.position = providedBoard.position
                    this.name = providedBoard.name
                    this.tasks = it.tasks
                    this.color = it.color
                }
            }

        val columnsExcept = inputColumnsById
            .values
            .map {
                BoardsColumn().apply {
                    this.position = it.position
                    this.name = it.name
                    this.color = ColorUtils.getRandom()
                }
            }

        columnRepository.deleteAll(board.columns)
        columnRepository.flush()

        val updatedBoard = boardRepository.save(
            Board().apply {
                this.id = board.id
                this.name = updateBoardRequestDto.name
                this.columns = (columnsIntersection + columnsExcept).sortedBy { it.position }.toMutableList()
                this.position = board.position
                this.userId = board.userId
            }
        )

        return ResponseEntity.ok(updatedBoard)
    }

}
