package com.kanban.controllers

import com.kanban.dtos.requests.CreateTaskRequestDto
import com.kanban.dtos.requests.UpdateTaskRequestDto
import com.kanban.models.Subtask
import com.kanban.models.Task
import com.kanban.repositories.BoardsColumnRepository
import com.kanban.repositories.SubtaskRepository
import com.kanban.repositories.TaskRepository
import org.jooq.DSLContext
import org.modelmapper.ModelMapper
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException
import java.net.URI
import java.util.*

@RestController
@RequestMapping(path = ["/api"])
class TaskController(
    val taskRepository: TaskRepository,
    val modelMapper: ModelMapper,
    val columnRepository: BoardsColumnRepository,
    val subtasksRepository: SubtaskRepository,
    val jooq: DSLContext
) {

    @DeleteMapping(path = ["/tasks/{id}"])
    fun deleteTask(@PathVariable id: UUID): ResponseEntity<Void> {
        taskRepository.deleteById(id)
        return ResponseEntity.noContent().build()
    }

    @PostMapping(path = ["/tasks"])
    fun createTask(@RequestBody createTaskRequestDto: CreateTaskRequestDto): ResponseEntity<Void> {
        val column = columnRepository.findById(UUID.fromString(createTaskRequestDto.status))
            .orElseThrow { ResponseStatusException(HttpStatus.BAD_REQUEST) }!!

        val task = modelMapper.map(createTaskRequestDto, Task::class.java)
        task.position = column.tasks.maxOfOrNull { it.position } ?: 0

        column.tasks.add(task)
        val savedColumn = columnRepository.save(column)

        val addedTask = savedColumn.tasks.last()
        return ResponseEntity.created(URI.create("/api/tasks/${addedTask.id}")).build()
    }

    @PutMapping(path = ["/tasks/{id}"])
    fun updateTask(@RequestBody updateTaskRequestDto: UpdateTaskRequestDto, @PathVariable id: UUID): ResponseEntity<Void> {
        if(updateTaskRequestDto.id != id) {
            throw ResponseStatusException(HttpStatus.BAD_REQUEST)
        }

        val task = taskRepository.findById(id)
            .orElseThrow { ResponseStatusException(HttpStatus.NOT_FOUND) }!!

        val originSubtasksById = task.subtasks.associateBy { it.id }

        val updatedSubtasks = updateTaskRequestDto.subtasks
            .map { modelMapper.map(it, Subtask::class.java) }
            .map {
                if(originSubtasksById.containsKey(it.id)){
                    it.isCompleted = originSubtasksById[it.id]?.isCompleted!!
                    it
                }
                else it
            }

        subtasksRepository.deleteAll(task.subtasks)
        subtasksRepository.flush()

        task.subtasks = updatedSubtasks.toMutableList()
        taskRepository.save(task)

        return ResponseEntity.ok().build()
    }


}
