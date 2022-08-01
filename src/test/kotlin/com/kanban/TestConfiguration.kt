package com.kanban

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType
import javax.sql.DataSource

@Configuration
class TestConfiguration {

    @Bean
    @Primary
    fun databaseSource(): DataSource {
        return EmbeddedDatabaseBuilder()
            .generateUniqueName(true)
            .setType(EmbeddedDatabaseType.H2)
            .setScriptEncoding(Charsets.UTF_8.name())
            .ignoreFailedDrops(true)
            .addScripts("init.sql", "data-inserts.sql")
            .build()
    }

}
