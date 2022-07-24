package com.kanban.controllers

import com.kanban.dtos.requests.CreateBoardRequestDto
import com.kanban.dtos.requests.UpdateBoardRequestDto
import com.kanban.dtos.responses.CreateBoardResponseDto
import com.kanban.dtos.responses.GetBoardResponseDto
import com.kanban.dtos.responses.GetBoardsResponseDto
import com.kanban.dtos.responses.UpdateBoardResponseDto
import com.kanban.models.Board
import com.kanban.repositories.BoardRepository
import org.modelmapper.ModelMapper
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException
import java.net.URI
import java.util.*


@RestController
@RequestMapping(path = ["/api"])
class BoardsController(
    val boardRepository: BoardRepository,
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

    @PutMapping(path = ["/boards/{id}"])
    fun updateBoard(@RequestBody updateBoardRequestDto: UpdateBoardRequestDto, @PathVariable id: UUID): ResponseEntity<Board> {
        val board = modelMapper.map(updateBoardRequestDto, Board::class.java)
        boardRepository.save(board)

        return ResponseEntity.ok(board)
    }

}
