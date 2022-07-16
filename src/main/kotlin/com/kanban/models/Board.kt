package com.kanban.models

import java.util.*
import javax.persistence.CascadeType
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.OneToMany

@Entity(name = "Boards")
class Board(
    val name: String,
    @OneToMany(cascade = [CascadeType.MERGE, CascadeType.PERSIST])
    val columns: MutableSet<BoardsColumn>
) {

    @Id
    var id: UUID = UUID.randomUUID()

    constructor(): this("", mutableSetOf())

}
