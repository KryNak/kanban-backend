package com.kanban.models

import java.util.*
import javax.persistence.*


@Entity(name = "Tasks")
class Task {

    @Id
    var id: UUID? = null

    var title: String = ""

    var description: String = ""

    var status: String = ""

    @OneToMany(cascade = [CascadeType.MERGE, CascadeType.PERSIST])
    @JoinColumn(name = "task_id")
    var subtasks: MutableSet<Subtask> = mutableSetOf()

    @PrePersist
    fun setup() {
        id = UUID.randomUUID()
    }
}
