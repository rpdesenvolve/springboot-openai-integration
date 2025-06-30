package br.com.rpdesenvolve.springboot_openai_integration.service

import com.aallam.openai.api.BetaOpenAI
import com.aallam.openai.api.chat.ChatCompletionRequest
import com.aallam.openai.api.chat.ChatMessage
import com.aallam.openai.api.chat.ChatRole
import com.aallam.openai.api.model.ModelId
import com.aallam.openai.client.OpenAI
import kotlinx.coroutines.runBlocking
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

@Service
class OpenAIService(
    @Value("\${openai.api-key}")
    private val openAiKey: String
) {

    private val openAI by lazy { OpenAI(openAiKey) }

    @OptIn(BetaOpenAI::class)
    fun ask(message: String): String = runBlocking {
        val chatCompletion = openAI.chatCompletion(
            request = ChatCompletionRequest(
                model = ModelId("gpt-3.5-turbo"),
                messages = listOf(
                    ChatMessage(role = ChatRole.User, content = message)
                )
            )
        )
        chatCompletion.choices.firstOrNull()?.message?.content ?: "No response from OpenAI"
    }
}