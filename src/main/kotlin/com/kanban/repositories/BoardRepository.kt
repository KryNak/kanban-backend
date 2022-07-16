package com.kanban.repositories

import com.kanban.models.Board
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface BoardRepository: JpaRepository<Board, UUID> {
}
