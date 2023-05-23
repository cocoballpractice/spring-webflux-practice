package dev.be.r2dbc

import org.springframework.data.repository.reactive.ReactiveCrudRepository
import reactor.core.publisher.Mono

interface R2BookRepository : ReactiveCrudRepository<R2Book, Long> {

    fun findByName(name : String) : Mono<R2Book>

}