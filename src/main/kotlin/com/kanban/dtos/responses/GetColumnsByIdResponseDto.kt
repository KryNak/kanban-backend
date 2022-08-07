package com.kanban.dtos.responses

import java.util.*

class GetColumnsByIdResponseDto {
    var id: UUID? = null
    var name: String = ""
    var tasks: MutableList<GetColumnsByIdTaskResponseDto> = mutableListOf()
    var position: Int = 0
}

class GetColumnsByIdTaskResponseDto {
    var id: UUID? = null
    var title: String = ""
    var description: String = ""
    var status: String = ""
    var subtasks: MutableList<GetColumnsByIdSubtaskResponseDto> = mutableListOf()
    var position: Int = 0
}

class GetColumnsByIdSubtaskResponseDto {
    var id: UUID? = null
    var title: String = ""
    var isCompleted: Boolean = false
    var position: Int = 0
}
