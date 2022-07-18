package com.kanban.models

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import java.util.*
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.PrePersist

@Entity(name = "subtasks")
@JsonIgnoreProperties(ignoreUnknown = true)
class Subtask {

    @Id
    var id: UUID? = null

    var title: String = ""
    var isCompleted: Boolean = false

    @PrePersist
    fun setup() {
        id = UUID.randomUUID()
    }
}
