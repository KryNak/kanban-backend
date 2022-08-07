package com.kanban.dtos.requests

import java.util.UUID

class UpdateBoardRequestDto {

    var id: UUID? = null
    var name: String = ""
    var columns: MutableList<UpdateBoardsColumnRequestDto> = mutableListOf()

    class UpdateBoardsColumnRequestDto {

        var id: UUID? = null
        var name: String = ""
        var position: Int = 0

    }

}
