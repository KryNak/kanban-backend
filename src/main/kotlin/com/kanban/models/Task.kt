package com.kanban.models

import java.util.*
import javax.persistence.CascadeType
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.OneToMany

@Entity(name = "Tasks")
class Task(
    val title: String,
    val description: String,
    val status: String,
    @OneToMany(cascade = [CascadeType.MERGE, CascadeType.PERSIST])
    val subtasks: MutableSet<Subtask>
) {

    @Id
    var id: UUID = UUID.randomUUID()

    constructor(): this("", "", "", mutableSetOf())
}
