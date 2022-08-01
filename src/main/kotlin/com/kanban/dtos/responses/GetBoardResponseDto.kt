package com.kanban.dtos.responses

import java.util.UUID

class GetBoardResponseDto {

    var id: UUID? = null
    var name: String = ""

    var columns: MutableList<ColumnDto> = mutableListOf()

    class ColumnDto {
        var id: UUID? = null
        var name: String = ""
        var position: Int = 0
    }

}
