package com.kanban.repositories

import com.kanban.models.Subtask
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface SubtaskRepository: JpaRepository<Subtask, UUID> {
}
