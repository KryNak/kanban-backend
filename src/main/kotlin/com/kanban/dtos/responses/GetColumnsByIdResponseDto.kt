package com.kanban.dtos.responses

import java.util.*

class GetColumnsByIdResponseDto {
    var id: UUID? = null
    var name: String = ""
    var tasks: MutableList<TaskDto> = mutableListOf()
    var position: Int = 0
}

class TaskDto {
    var id: UUID? = null
    var title: String = ""
    var description: String = ""
    var status: String = ""
    var subtasks: MutableList<SubtaskDto> = mutableListOf()
    var position: Int = 0
}

class SubtaskDto {
    var id: UUID? = null
    var title: String = ""
    var isCompleted: Boolean = false
    var position: Int = 0
}
