package com.kanban.controllers

import com.kanban.dtos.responses.GetColumnResponseDto
import com.kanban.dtos.responses.GetColumnsByIdResponseDto
import com.kanban.dtos.responses.GetColumnsByIdSubtaskResponseDto
import com.kanban.dtos.responses.GetColumnsByIdTaskResponseDto
import com.kanban.jooq.Tables.*
import com.kanban.repositories.BoardsColumnRepository
import org.jooq.DSLContext
import org.jooq.impl.DSL.asterisk
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
    val columnRepository: BoardsColumnRepository,
    val jooq: DSLContext
) {

    @GetMapping(path = ["/columns"])
    fun getColumns(): ResponseEntity<List<GetColumnResponseDto>> {
        return columnRepository.findAll()
            .map { modelMapper.map(it, GetColumnResponseDto::class.java) }
            .let { ResponseEntity.ok(it) }
    }

    @GetMapping(path = ["/columns/{id}"])
    fun getColumn(@PathVariable id: UUID): ResponseEntity<GetColumnsByIdResponseDto> {

        val tasks = jooq.select(asterisk())
            .from(TASKS)
            .where(TASKS.COLUMN_ID.eq(id))
            .orderBy(TASKS.POSITION)
            .fetchInto(GetColumnsByIdTaskResponseDto::class.java)
            .map {
                it.apply {
                    subtasks = jooq.select(asterisk())
                        .from(SUBTASKS)
                        .where(SUBTASKS.TASK_ID.eq(it.id))
                        .orderBy(SUBTASKS.POSITION)
                        .fetchInto(GetColumnsByIdSubtaskResponseDto::class.java)
                }
            }

        val column = jooq.select(asterisk())
            .from(COLUMNS)
            .where(COLUMNS.ID.eq(id))
            .limit(1)
            .fetchOneInto(GetColumnsByIdResponseDto::class.java)
            ?: throw ResponseStatusException(HttpStatus.NOT_FOUND)

        column.tasks = tasks.toMutableList()

        return ResponseEntity.ok(column)
    }
}
