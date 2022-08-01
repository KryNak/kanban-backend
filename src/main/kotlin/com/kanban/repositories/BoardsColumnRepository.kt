package com.kanban.repositories

import com.kanban.models.BoardsColumn
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import java.util.UUID

interface BoardsColumnRepository: JpaRepository<BoardsColumn, UUID> {



}
