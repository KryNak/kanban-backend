package com.kanban.dtos.responses

import java.util.UUID

class GetBoardResponseDto {

    var id: UUID? = null
    var name: String = ""

    var columns: MutableSet<ColumnDto> = mutableSetOf()

    class ColumnDto {
        var id: UUID? = null
        var name: String = ""
    }

}
