package com.kanban.models

import java.util.*
import javax.persistence.CascadeType
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.OneToMany

@Entity(name = "columns")
class BoardsColumn(
    val name: String,
    @OneToMany(cascade = [CascadeType.MERGE, CascadeType.PERSIST])
    val tasks: MutableSet<Task>
) {

    @Id
    var id: UUID = UUID.randomUUID()

    constructor(): this("", mutableSetOf())
}
