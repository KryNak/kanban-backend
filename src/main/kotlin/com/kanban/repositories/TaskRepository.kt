package com.kanban.repositories

import com.kanban.models.Task
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface TaskRepository: JpaRepository<Task, UUID> {
}
