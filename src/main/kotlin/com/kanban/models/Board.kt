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

    @OneToMany(cascade = [CascadeType.MERGE, CascadeType.PERSIST])
    @JoinColumn(name = "board_id")
    var columns: MutableSet<BoardsColumn> = mutableSetOf()

    @PrePersist
    fun setup() {
        id = UUID.randomUUID()
    }
}
