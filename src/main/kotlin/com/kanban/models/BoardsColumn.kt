package com.kanban.models

import java.util.*
import javax.persistence.*

@Entity(name = "columns")
class BoardsColumn {

    @Id
    var id: UUID? = null

    var name: String = ""

    @OneToMany(cascade = [CascadeType.MERGE, CascadeType.PERSIST])
    @JoinColumn(name = "column_id")
    var tasks: MutableSet<Task> = mutableSetOf()

    @PrePersist
    fun setup() {
        id = UUID.randomUUID()
    }
}
