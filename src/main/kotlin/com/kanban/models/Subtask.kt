package com.kanban.models

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import java.util.*
import javax.persistence.Entity
import javax.persistence.Id

@Entity(name = "subtasks")
@JsonIgnoreProperties(ignoreUnknown = true)
class Subtask(
    val title: String,
    val isCompleted: Boolean
) {

    @Id
    var id: UUID = UUID.randomUUID()

    constructor(): this("", false)
}
