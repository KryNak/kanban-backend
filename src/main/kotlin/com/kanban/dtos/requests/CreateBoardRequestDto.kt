package com.kanban.dtos.requests

class CreateBoardRequestDto {

    var name: String = ""
    var columns: MutableSet<ColumnDto> = mutableSetOf()

    class ColumnDto {
        var name: String = ""
    }

}
