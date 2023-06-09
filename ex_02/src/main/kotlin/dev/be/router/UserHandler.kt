package dev.be.router

import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import reactor.core.publisher.Mono

data class User(val id: Long, val email: String)

@Component
class UserHandler {

    val users = listOf(
        User(id = 1, email = "test1@test.com"),
        User(id = 2, email = "test2@test.com")
    )

    fun getUser(req: ServerRequest) : Mono<ServerResponse> =
        // @PathVariable
        users.find { req.pathVariable("id").toLong() == it.id }?.let {
            ServerResponse.ok().bodyValue(it)
        } ?: ServerResponse.notFound().build()

    fun getAll(req: ServerRequest) : Mono<ServerResponse> =
        ServerResponse.ok().bodyValue(users)
}