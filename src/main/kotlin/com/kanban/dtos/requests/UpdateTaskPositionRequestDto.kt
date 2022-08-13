package com.kanban.dtos.requests

import java.util.UUID

class UpdateTaskPositionRequestDto(
    val taskId: UUID,
    val destinationColumnId: UUID,
    val destinationTaskPosition: Int
)
