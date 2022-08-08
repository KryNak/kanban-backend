package com.kanban.dtos.requests

import java.util.UUID

class UpdateTaskRequestDto {
    val id: UUID? = null
    val title: String = ""
    val description: String = ""
    val columnId: UUID? = null
    val subtasks: MutableList<UpdateTasksSubtaskRequestDto> = mutableListOf()
}

class UpdateTasksSubtaskRequestDto {
    var id: UUID? = null
    var title: String = ""
    var isCompleted: Boolean = false
    var position: Int = 0
}
