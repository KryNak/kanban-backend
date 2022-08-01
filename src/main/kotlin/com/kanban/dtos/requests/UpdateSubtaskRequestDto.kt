package com.kanban.dtos.requests

import java.util.*

class UpdateSubtaskRequestDto(
    val id: UUID,
    var isCompleted: Boolean
) {

}
