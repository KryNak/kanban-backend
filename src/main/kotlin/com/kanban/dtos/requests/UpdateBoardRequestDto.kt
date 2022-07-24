package com.kanban.dtos.requests

import java.util.UUID

class UpdateBoardRequestDto {

    var id: UUID? = null
    var name: String = ""
    var columns: MutableSet<ColumnDto> = mutableSetOf()

    class ColumnDto {

        var id: UUID? = null
        var name: String = ""

    }

}
