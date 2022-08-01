package com.kanban.dtos.requests

import java.util.UUID

class UpdateBoardRequestDto {

    var id: UUID? = null
    var name: String = ""
    var columns: MutableList<ColumnDto> = mutableListOf()

    class ColumnDto {

        var id: UUID? = null
        var name: String = ""
        var position: Int = 0

    }

}
