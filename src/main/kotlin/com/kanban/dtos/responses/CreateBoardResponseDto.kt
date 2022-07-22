package com.kanban.dtos.responses

import java.util.*

class CreateBoardResponseDto {

    var id: UUID? = null
    var name: String = ""

    var columns: MutableSet<ColumnDto> = mutableSetOf()

    class ColumnDto {
        var id: UUID? = null
        var name: String = ""
    }

}
