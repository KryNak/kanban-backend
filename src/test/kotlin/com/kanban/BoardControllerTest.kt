package com.kanban

import com.kanban.dtos.responses.GetColumnsByIdResponseDto
import com.kanban.jooq.Tables
import org.jooq.DSLContext
import org.jooq.SQLDialect
import org.jooq.impl.DSL
import org.jooq.impl.DSL.asterisk
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import javax.annotation.PostConstruct
import javax.sql.DataSource

@SpringBootTest
@AutoConfigureMockMvc
class BoardsControllerTest {

    @Autowired
    lateinit var databaseSource: DataSource

    lateinit var jooq: DSLContext

    @PostConstruct
    fun setup() {
       jooq = DSL.using(databaseSource, SQLDialect.H2)
    }

    @Test
    fun test_update_board() {
        val result = jooq.select(asterisk())
            .from(Tables.COLUMNS)
            .fetch { GetColumnsByIdResponseDto::class.java }

        println(result)
    }

}
