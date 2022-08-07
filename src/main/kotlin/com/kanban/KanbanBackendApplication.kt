package com.kanban

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KanbanBackendApplication {
    companion object {
        init {
            System.getProperties().setProperty("org.jooq.no-logo", "true");
        }
    }
}

fun main(args: Array<String>) {
    runApplication<KanbanBackendApplication>(*args)
}
