package br.com.rpdesenvolve.springboot_openai_integration.controller

import br.com.rpdesenvolve.springboot_openai_integration.controller.dto.ChatRequest
import br.com.rpdesenvolve.springboot_openai_integration.controller.dto.ChatResponse
import br.com.rpdesenvolve.springboot_openai_integration.service.OpenAIService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/chat")
@Tag(name = "Chat", description = "Send messages to the OpenAI model")
class ChatController(
    private val openAIService: OpenAIService
) {

    @Operation(summary = "Send message to ChatGPT")
    @PostMapping
    fun chat(@RequestBody request: ChatRequest): ChatResponse {
        val reply = openAIService.ask(request.message)
        return ChatResponse(reply)
    }
}