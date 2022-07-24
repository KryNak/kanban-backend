package com.kanban.controllers

import com.kanban.dtos.responses.GetColumnResponseDto
import com.kanban.dtos.responses.GetColumnsByIdResponseDto
import com.kanban.repositories.BoardsColumnRepository
import org.modelmapper.ModelMapper
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.server.ResponseStatusException
import java.util.UUID

@RestController
@RequestMapping(path = ["/api"])
class BoardsColumnController(
    val modelMapper: ModelMapper,
    val columnRepository: BoardsColumnRepository
) {

    @GetMapping(path = ["/columns"])
    fun getColumns(): ResponseEntity<List<GetColumnResponseDto>> {
        return columnRepository.findAll()
            .map { modelMapper.map(it, GetColumnResponseDto::class.java) }
            .let { ResponseEntity.ok(it) }
    }

    @GetMapping(path = ["/columns/{id}"])
    fun getColumn(@PathVariable id: UUID): ResponseEntity<GetColumnsByIdResponseDto> {
        return columnRepository.findById(id)
            .map { modelMapper.map(it, GetColumnsByIdResponseDto::class.java) }
            .map { ResponseEntity.ok(it) }
            .orElseThrow { ResponseStatusException(HttpStatus.NOT_FOUND) }
    }

}
