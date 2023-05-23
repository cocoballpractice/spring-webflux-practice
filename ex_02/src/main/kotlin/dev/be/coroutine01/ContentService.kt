package dev.be.coroutine01

import kotlinx.coroutines.reactor.awaitSingle
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

class ContentService(
    val repository: ContentReactiveRepository,
    val coroutineRepository: ContentCoroutineRepository
) {

    fun findAllByUserId(userId: Long) : Flux<Content> {
        return repository.findAllByUserId(userId)
    }

    // 리액티브
    fun findByUserIdMono(userId : Long) : Mono<Content> {
        return repository.findByUserId(userId)
    }

    // 코루틴
    suspend fun findByUserId(userId: Long) : Content {
        return repository.findByUserId(userId).awaitSingle()
    }

    // 코루틴 리포지토리 사용
    suspend fun findByUserIdCoroutine(userId: Long) : Content? {
        return coroutineRepository.findByUserId(userId)
    }

}