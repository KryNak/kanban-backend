package com.kanban.dtos.requests

class CreateBoardRequestDto {

    var name: String = ""
    var columns: MutableList<CreateBoardsColumnRequestDto> = mutableListOf()

    class CreateBoardsColumnRequestDto {
        var name: String = ""
    }

}
