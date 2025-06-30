package br.com.rpdesenvolve.springboot_openai_integration.controller

import br.com.rpdesenvolve.springboot_openai_integration.controller.dto.ChatRequest
import br.com.rpdesenvolve.springboot_openai_integration.service.OpenAIService
import com.fasterxml.jackson.databind.ObjectMapper
import org.mockito.Mockito.`when`
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import kotlin.test.Test

@WebMvcTest(ChatController::class)
class ChatControllerTest {

    @Autowired
    lateinit var mockMvc: MockMvc

    @MockBean
    lateinit var openAIService: OpenAIService

    @Autowired
    lateinit var objectMapper: ObjectMapper

    @Test
    fun `should return chat reply`() {
        val message = "O que é Kotlin?"
        val expectedReply = "Kotlin é uma linguagem moderna."

        `when`(openAIService.ask(message)).thenReturn(expectedReply)

        val requestJson = objectMapper.writeValueAsString(ChatRequest(message))

        mockMvc.perform(
            MockMvcRequestBuilders.post("/chat")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestJson)
        )
            .andExpect(MockMvcResultMatchers.status().isOk)
            .andExpect(MockMvcResultMatchers.jsonPath("$.reply").value(expectedReply))
    }
}