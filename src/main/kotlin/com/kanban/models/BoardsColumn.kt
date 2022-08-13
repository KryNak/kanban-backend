package com.kanban.models

import java.util.*
import javax.persistence.*

//@Table(uniqueConstraints = [UniqueConstraint(name = "column_position", columnNames = ["board_id", "position"])])
@Entity(name = "columns")
class BoardsColumn {

    @Id
    var id: UUID? = null

    var name: String = ""

    var position: Int = 0

    var color: String = ""

    @OneToMany(cascade = [CascadeType.MERGE, CascadeType.PERSIST])
    @JoinColumn(name = "column_id")
    var tasks: MutableList<Task> = mutableListOf()

    @PrePersist
    fun setup() {
        id = id ?: UUID.randomUUID()
    }
}
