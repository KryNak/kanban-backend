package com.kanban.controllers

import com.kanban.dtos.requests.CreateBoardRequestDto
import com.kanban.dtos.requests.UpdateBoardRequestDto
import com.kanban.dtos.responses.CreateBoardResponseDto
import com.kanban.dtos.responses.GetBoardResponseDto
import com.kanban.dtos.responses.GetBoardsResponseDto
import com.kanban.models.Board
import com.kanban.models.BoardsColumn
import com.kanban.repositories.BoardRepository
import com.kanban.repositories.BoardsColumnRepository
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
    val modelMapper: ModelMapper
) {

    @GetMapping(path = ["/boards"])
    fun getBoards(): ResponseEntity<List<GetBoardsResponseDto>> {

        val boards = boardRepository.findAll()
            .map { modelMapper.map(it, GetBoardsResponseDto::class.java) }

        return ResponseEntity.ok(boards)
    }

    @DeleteMapping(path = ["/boards/{id}"])
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    fun deleteBoard(@PathVariable id: UUID) {
        boardRepository.findById(id)
            .ifPresent { boardRepository.deleteById(id) }
    }

    @GetMapping(path = ["/boards/{id}"])
    fun getBoard(@PathVariable id: UUID): ResponseEntity<GetBoardResponseDto> {
        return boardRepository.findById(id)
            .map { ResponseEntity.ok(modelMapper.map(it, GetBoardResponseDto::class.java)) }
            .orElseThrow { ResponseStatusException(HttpStatus.NOT_FOUND) }
    }

    @PostMapping(path = ["/boards"])
    fun createBoard(@RequestBody createBoardRequest: CreateBoardRequestDto): ResponseEntity<CreateBoardResponseDto> {
        val savedBoard = boardRepository.save(modelMapper.map(createBoardRequest, Board::class.java))
        return ResponseEntity.created(URI.create("/api/boards/${savedBoard.id}")).body(modelMapper.map(savedBoard, CreateBoardResponseDto::class.java))
    }

    @Transactional
    @PutMapping(path = ["/boards/{id}"])
    fun updateBoard(@RequestBody updateBoardRequestDto: UpdateBoardRequestDto, @PathVariable id: UUID): ResponseEntity<Board> {
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
                }
            }

        val columnsExcept = inputColumnsById
            .values
            .map {
                BoardsColumn().apply {
                    this.position = it.position
                    this.name = it.name
                }
            }

        columnRepository.deleteAll(board.columns)
        columnRepository.flush()

        val updatedBoard = boardRepository.save(
            Board().apply {
                this.id = board.id
                this.name = board.name
                this.columns = (columnsIntersection + columnsExcept).sortedBy { it.position }.toMutableList()
            }
        )

        return ResponseEntity.ok(updatedBoard)
    }

}
