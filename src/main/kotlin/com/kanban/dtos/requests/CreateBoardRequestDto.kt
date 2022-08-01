package com.kanban.dtos.requests

class CreateBoardRequestDto {

    var name: String = ""
    var columns: MutableList<ColumnDto> = mutableListOf()

    class ColumnDto {
        var name: String = ""
    }

}
