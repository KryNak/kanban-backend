package com.kanban.config

import org.modelmapper.ModelMapper
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
class BeansDeclaration {

    @Bean
    fun modelMapper(): ModelMapper {
        return ModelMapper()
    }


}
