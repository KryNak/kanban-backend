package com.kanban.models

import java.util.*
import javax.persistence.CascadeType
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.OneToMany
import javax.persistence.PrePersist

@Entity(name = "Boards")
class Board {

    @Id
    var id: UUID? = null

    var name: String = ""

    var position: Int = 0

    @OneToMany(cascade = [CascadeType.MERGE, CascadeType.PERSIST])
    @JoinColumn(name = "board_id")
    var columns: MutableList<BoardsColumn> = mutableListOf()

    @PrePersist
    fun setup() {
        id = id ?: UUID.randomUUID()
    }
}
