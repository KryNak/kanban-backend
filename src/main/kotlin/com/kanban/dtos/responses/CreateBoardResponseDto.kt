package com.kanban.dtos.responses

import java.util.*

class CreateBoardResponseDto {

    var id: UUID? = null
    var name: String = ""

    var columns: MutableList<ColumnDto> = mutableListOf()

    class ColumnDto {
        var id: UUID? = null
        var name: String = ""
        var position: Int = 0
    }

}
