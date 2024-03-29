package com.kanban.controllers

import com.kanban.dtos.requests.CreateTaskRequestDto
import com.kanban.dtos.requests.UpdateTaskPositionRequestDto
import com.kanban.dtos.requests.UpdateTaskRequestDto
import com.kanban.jooq.Tables.*
import com.kanban.models.Subtask
import com.kanban.models.Task
import com.kanban.repositories.BoardsColumnRepository
import mu.KotlinLogging
import org.jooq.DSLContext
import org.jooq.impl.DSL.*
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
    val modelMapper: ModelMapper,
    val columnRepository: BoardsColumnRepository,
    val jooq: DSLContext
) {

    val logger = KotlinLogging.logger(TaskController::class.java.simpleName)

    @DeleteMapping(path = ["/tasks/{id}"])
    fun deleteTask(@PathVariable id: UUID): ResponseEntity<Void> {

        jooq.transaction { _ ->

            val task = jooq.select(asterisk())
                .from(TASKS)
                .where(TASKS.ID.eq(id))
                .fetchOneInto(TASKS)
                ?: throw ResponseStatusException(HttpStatus.NOT_FOUND)

            jooq.delete(SUBTASKS)
                .where(SUBTASKS.TASK_ID.eq(id))
                .execute()

            jooq.delete(TASKS)
                .where(TASKS.ID.eq(id))
                .execute()

            jooq.update(TASKS)
                .set(TASKS.POSITION, TASKS.POSITION.minus(1))
                .where(TASKS.COLUMN_ID.eq(task.columnId))
                .and(TASKS.POSITION.greaterThan(task.position))
                .execute()

        }

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

    @PutMapping(path = ["/tasks/{taskId}/status/{columnId}"])
    @ResponseStatus(HttpStatus.OK)
    fun updateTaskStatus(@PathVariable taskId: UUID, @PathVariable columnId: UUID) {
        jooq.transaction { _ ->
            updateStatus(taskId, columnId)
        }
    }

    @PutMapping(path = ["/tasks/{id}"])
    fun updateTask(@RequestBody updateTaskRequestDto: UpdateTaskRequestDto, @PathVariable id: UUID): ResponseEntity<Void> {

        if(updateTaskRequestDto.id != id){
            throw ResponseStatusException(HttpStatus.BAD_REQUEST)
        }

        jooq.transaction { _ ->
            updateStatus(id, updateTaskRequestDto.columnId!!)

            jooq.update(TASKS)
                .set(TASKS.TITLE, updateTaskRequestDto.title)
                .set(TASKS.DESCRIPTION, updateTaskRequestDto.description)
                .set(TASKS.STATUS, select(COLUMNS.NAME).from(COLUMNS).where(COLUMNS.ID.eq(updateTaskRequestDto.columnId)))
                .where(TASKS.ID.eq(id))
                .execute()

            val subtasksAssignedToTask = jooq.select(asterisk())
                .from(SUBTASKS)
                .where(SUBTASKS.TASK_ID.eq(id))
                .fetchInto(Subtask::class.java)

            val providedSubtasksIds =  updateTaskRequestDto.subtasks
                .filter { it.id != null }
                .map { it.id }

            subtasksAssignedToTask.filter { it.id !in providedSubtasksIds }.forEach {
                jooq.delete(SUBTASKS)
                    .where(SUBTASKS.ID.eq(it.id))
                    .execute()
            }

            updateTaskRequestDto.subtasks.filter { it.id == null }.forEach{
                jooq.insertInto(SUBTASKS, SUBTASKS.ID, SUBTASKS.IS_COMPLETED, SUBTASKS.TITLE, SUBTASKS.POSITION, SUBTASKS.TASK_ID)
                    .values(UUID.randomUUID(), it.isCompleted, it.title, it.position, id)
                    .execute()
            }

            updateTaskRequestDto.subtasks.filter { it.id != null }.forEach {
                jooq.update(SUBTASKS)
                    .set(SUBTASKS.TITLE, it.title)
                    .set(SUBTASKS.POSITION, it.position)
                    .where(SUBTASKS.ID.eq(it.id))
                    .execute()
            }

        }

        return ResponseEntity.ok().build()
    }

    @PutMapping(path = ["/tasks/{taskId}/position"])
    fun updateTaskPosition(@RequestBody updateTaskPositionRequestDto: UpdateTaskPositionRequestDto, @PathVariable taskId: UUID): ResponseEntity<Void> {
        if(updateTaskPositionRequestDto.taskId != taskId) {
            throw ResponseStatusException(HttpStatus.BAD_REQUEST)
        }

        updateStatus(
            taskId = updateTaskPositionRequestDto.taskId,
            destinationColumnId = updateTaskPositionRequestDto.destinationColumnId,
            destinationPosition = updateTaskPositionRequestDto.destinationTaskPosition
        )

        return ResponseEntity.ok().build()
    }

    fun updateStatus(taskId: UUID, destinationColumnId: UUID, destinationPosition: Int = -1) {
        val task = jooq.select(asterisk())
            .from(TASKS)
            .where(TASKS.ID.eq(taskId))
            .fetchOneInto(TASKS)
            ?: throw ResponseStatusException(HttpStatus.NOT_FOUND)

        val columnName = jooq.select(COLUMNS.NAME)
            .from(COLUMNS)
            .where(COLUMNS.ID.eq(destinationColumnId))
            .fetchOneInto(String::class.java)

        if(task.columnId != destinationColumnId && destinationPosition == -1){

            jooq.update(TASKS)
                .set(TASKS.POSITION, select(count()).from(TASKS).where(TASKS.COLUMN_ID.eq(destinationColumnId)))
                .set(TASKS.COLUMN_ID, destinationColumnId)
                .set(TASKS.STATUS, columnName)
                .where(TASKS.ID.eq(taskId))
                .execute()

            jooq.update(TASKS)
                .set(TASKS.POSITION, TASKS.POSITION.minus(1))
                .where(TASKS.POSITION.greaterThan(task.position))
                .and(TASKS.COLUMN_ID.eq(task.columnId))
                .execute()

        } else if (task.columnId != destinationColumnId && destinationPosition != -1) {

            jooq.update(TASKS)
                .set(TASKS.POSITION, TASKS.POSITION.minus(1))
                .where(TASKS.COLUMN_ID.eq(task.columnId))
                .and(TASKS.POSITION.greaterThan(task.position))
                .execute()

            jooq.update(TASKS)
                .set(TASKS.POSITION, TASKS.POSITION.plus(1))
                .where(TASKS.POSITION.greaterOrEqual(destinationPosition))
                .and(TASKS.COLUMN_ID.eq(destinationColumnId))
                .execute()

            jooq.update(TASKS)
                .set(TASKS.COLUMN_ID, destinationColumnId)
                .set(TASKS.POSITION, destinationPosition)
                .set(TASKS.STATUS, columnName)
                .where(TASKS.ID.eq(task.id))
                .execute()

        } else if(task.columnId == destinationColumnId && destinationPosition != -1) {

            if(task.position > destinationPosition) {

                jooq.update(TASKS)
                    .set(TASKS.POSITION, TASKS.POSITION.plus(1))
                    .where(TASKS.POSITION.between(destinationPosition, task.position))
                    .and(TASKS.COLUMN_ID.eq(task.columnId))
                    .execute()

            } else if(task.position < destinationPosition) {

                jooq.update(TASKS)
                    .set(TASKS.POSITION, TASKS.POSITION.minus(1))
                    .where(TASKS.POSITION.between(task.position, destinationPosition))
                    .and(TASKS.COLUMN_ID.eq(task.columnId))
                    .execute()

            }

            jooq.update(TASKS)
                .set(TASKS.POSITION, destinationPosition)
                .where(TASKS.ID.eq(task.id))
                .execute()

        }
    }

}
