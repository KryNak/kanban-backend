package com.kanban.models

import java.util.*
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.PrePersist

//@Table(uniqueConstraints = [UniqueConstraint(name = "subtask_position", columnNames = ["position", "task_id"])])
@Entity(name = "subtasks")
class Subtask {

    @Id
    var id: UUID? = null

    var title: String = ""
    var isCompleted: Boolean = false
    var position: Int = 0

    @PrePersist
    fun setup() {
        id = id ?: UUID.randomUUID()
    }
}
