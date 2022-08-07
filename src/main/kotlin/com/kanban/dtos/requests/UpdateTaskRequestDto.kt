package com.kanban.dtos.requests

import java.util.UUID

class UpdateTaskRequestDto {
    val id: UUID? = null
    val title: String = ""
    val description: String = ""
    val status: String = ""
    val subtasks: MutableList<UpdateTasksSubtaskRequestDto> = mutableListOf()
}

class UpdateTasksSubtaskRequestDto {
    var id: UUID? = null
    var title: String = ""
    var isCompleted: Boolean = false
}
