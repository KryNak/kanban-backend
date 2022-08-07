package com.kanban.dtos.requests

import java.util.*

class UpdateSubtaskRequestDto(
    val id: UUID,
    val isCompleted: Boolean,
    val taskId: UUID
)
