package com.kanban.models

import java.util.*
import javax.persistence.*


@Table(uniqueConstraints = [UniqueConstraint(name = "task_position", columnNames = ["position", "column_id"])])
@Entity(name = "Tasks")
class Task {

    @Id
    var id: UUID? = null

    var title: String = ""

    var description: String = ""

    var status: String = ""

    var position: Int = 0

    @OneToMany(cascade = [CascadeType.MERGE, CascadeType.PERSIST])
    @JoinColumn(name = "task_id")
    var subtasks: MutableList<Subtask> = mutableListOf()

    @PrePersist
    fun setup() {
        id = id ?: UUID.randomUUID()
    }
}
