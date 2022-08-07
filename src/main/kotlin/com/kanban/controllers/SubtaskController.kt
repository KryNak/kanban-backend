package com.kanban.controllers

import com.kanban.dtos.requests.UpdateSubtaskRequestDto
import com.kanban.jooq.Tables
import mu.KotlinLogging
import org.jooq.DSLContext
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.UUID
import javax.transaction.Transactional

@RestController
@RequestMapping(path = ["/api"])
class SubtaskController(val jooq: DSLContext) {

    private val logger = KotlinLogging.logger {  }

    @Transactional
    @PutMapping(path = ["/subtasks/{id}"])
    fun updateSubtask(@RequestBody updateSubtaskRequestDto: UpdateSubtaskRequestDto, @PathVariable(name = "id") id: UUID): ResponseEntity<Void> {

        jooq.update(Tables.SUBTASKS)
            .set(Tables.SUBTASKS.IS_COMPLETED, updateSubtaskRequestDto.isCompleted)
            .where(Tables.SUBTASKS.ID.eq(updateSubtaskRequestDto.id))
            .execute()

        return ResponseEntity.ok().build()
    }


}
