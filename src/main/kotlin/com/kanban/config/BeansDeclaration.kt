package com.kanban.config

import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.ObjectMapper
import com.kanban.models.Board
import com.kanban.repositories.BoardRepository
import org.modelmapper.ModelMapper
import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class BeansDeclaration(
    val boardsRepository: BoardRepository
) {

    @Bean
    fun modelMapper(): ModelMapper {
        return ModelMapper()
    }

    @Bean
    fun loadDataFromJson() = CommandLineRunner {
        val json = BeansDeclaration::class.java.classLoader.getResource("data.json")?.readText(Charsets.UTF_8) ?: ""
        val boardsByKey = ObjectMapper().readValue(json, object : TypeReference<Map<String, List<Board>>>() {})

        boardsRepository.saveAll(boardsByKey["boards"].orEmpty())
    }

}
