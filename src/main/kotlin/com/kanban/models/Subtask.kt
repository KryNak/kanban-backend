package com.kanban.models

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import java.util.*
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.PrePersist
import javax.persistence.Table
import javax.persistence.UniqueConstraint

@Table(uniqueConstraints = [UniqueConstraint(name = "subtask_position", columnNames = ["position", "task_id"])])
@Entity(name = "subtasks")
//@JsonIgnoreProperties(ignoreUnknown = true)
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
