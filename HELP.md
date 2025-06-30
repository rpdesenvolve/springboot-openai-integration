# springboot-openai-integration

REST API in Kotlin with Spring Boot that integrates with OpenAI (ChatGPT).

## 🔧 Stack
- Kotlin
- Spring Boot
- OpenAI (via [openai-kotlin](https://github.com/aallam/openai-kotlin))
- Swagger UI
- Testing with MockMvc and MockK

## 📦 Running

1. Create a `.env` file **or set the environment variable** with:
```
OPENAI_API_KEY=your_key_here
```

2. Run the project:
```
./gradlew bootRun
```

3. Access Swagger:
```
http://localhost:8080/swagger-ui/index.html
```

## 🧪 Testing the endpoint
```
POST /chat
{
"message": "What is Kotlin?" }
```

Response:
```json
{
"reply": "Kotlin is a modern, concise and secure language..."
}
```

## 🧪 Running the tests
```
./gradlew test
```

---

> Developed by [Ricardo Proença](https://www.linkedin.com/in/ricardoproenca-dev/) ✨