package dev.be.coroutine01

import org.springframework.data.repository.reactive.ReactiveCrudRepository
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface ContentReactiveRepository : ReactiveCrudRepository<Content, Long> {

    fun findByUserId(userId : Long) : Mono<Content>

    fun findAllByUserId(userId : Long) : Flux<Content>

}