package com.kanban.dtos.requests

class CreateTaskRequestDto(
    val title: String,
    val description: String,
    val status: String,
    val subtasks: List<CreateTasksSubtasksRequestDto>
)

class CreateTasksSubtasksRequestDto(
    val title: String,
    val position: Int
)
