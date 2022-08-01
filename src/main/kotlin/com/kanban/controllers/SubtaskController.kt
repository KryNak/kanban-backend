package com.kanban.controllers

import com.kanban.dtos.requests.UpdateSubtaskRequestDto
import com.kanban.repositories.SubtaskRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.server.ResponseStatusException
import java.util.UUID

@RestController
@RequestMapping(path = ["/api"])
class SubtaskController(val subtaskRepository: SubtaskRepository) {

    @PutMapping(path = ["/subtasks/{id}"])
    fun updateSubtask(@RequestBody updateSubtaskRequestDto: UpdateSubtaskRequestDto, @RequestParam id: UUID): ResponseEntity<Void> {
        val subtask = subtaskRepository.findById(id)
            .orElseThrow { ResponseStatusException(HttpStatus.NOT_FOUND) }!!

        subtask.isCompleted = updateSubtaskRequestDto.isCompleted

        subtaskRepository.save(subtask)
        return ResponseEntity.ok().build()
    }


}
