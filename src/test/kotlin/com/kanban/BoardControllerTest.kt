package com.kanban

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.kanban.dtos.requests.UpdateBoardRequestDto
import com.kanban.models.Board
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers

@SpringBootTest
@AutoConfigureMockMvc
class BoardsControllerTest {

    @Autowired
    lateinit var mockMvc: MockMvc

    @Test
    fun test_update_board() {
        val exampleRequestBody = "{\"id\":\"268f63a7-6fad-450e-8690-bd50b1418ec3\",\"name\":\"Marketing Plan\",\"columns\":[{\"id\":\"5a10bfaf-9114-4108-9dfe-8d5148bff184\",\"name\":\"Backlog\",\"position\":0},{\"id\":\"83c3a7c1-0e71-4dad-82a9-eaa02f8abd14\",\"name\":\"Todo\",\"position\":1},{\"id\":\"6c0ff696-52ff-432f-974d-7fc8239cd330\",\"name\":\"Doing\",\"position\":2},{\"id\":null,\"name\":\"Done\",\"position\":3}]}"
        val requestBody = jacksonObjectMapper().readValue(exampleRequestBody, UpdateBoardRequestDto::class.java)

        val httpResponse = mockMvc.perform(
            MockMvcRequestBuilders
                .put("/api/boards/{id}", requestBody.id)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(exampleRequestBody)
        )
            .andExpect(MockMvcResultMatchers.status().isOk)
            .andReturn()
            .response

        val responseBody = jacksonObjectMapper().readValue(httpResponse.contentAsString, Board::class.java)
    }

}
