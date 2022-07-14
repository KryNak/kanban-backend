package com.kanban

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KanbanBackendApplication

fun main(args: Array<String>) {
    runApplication<KanbanBackendApplication>(*args)
}
