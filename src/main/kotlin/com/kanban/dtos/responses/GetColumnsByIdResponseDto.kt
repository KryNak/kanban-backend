package com.kanban.dtos.responses

import java.util.*

class GetColumnsByIdResponseDto {
    var id: UUID? = null
    var name: String = ""
    var tasks: MutableSet<TaskDto> = mutableSetOf()
}

class TaskDto {
    var id: UUID? = null
    var title: String = ""
    var description: String = ""
    var status: String = ""
    var subtasks: MutableSet<SubtaskDto> = mutableSetOf()
}

class SubtaskDto {
    var id: UUID? = null
    var title: String = ""
    var isCompleted: Boolean = false
}
