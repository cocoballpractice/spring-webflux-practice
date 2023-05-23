package dev.be.coroutine01

import kotlinx.coroutines.flow.Flow
import org.springframework.data.repository.kotlin.CoroutineCrudRepository

interface ContentCoroutineRepository : CoroutineCrudRepository<Content, Long> {

    suspend fun findByUserId(userId : Long) : Content?

    fun findAllByUserId(userId: Long) : Flow<Content>

}