package dev.be.book

import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import reactor.kotlin.core.publisher.toFlux
import reactor.kotlin.core.publisher.toMono
import java.util.concurrent.atomic.AtomicInteger

data class Book(val id : Int, val name : String, val price : Int)

@Service
class BookService {

    private final val nextId = AtomicInteger(0)

    val books = mutableListOf(
        Book(id = nextId.incrementAndGet(), name = "코틀린 인 액션", price=30000),
        Book(id = nextId.incrementAndGet(), name = "HTTP 완벽 가이드", price=40000)
    )

    fun getAll() : Flux<Book> {
        // iterable한 객체(컬렉션)을 Flux로 변환
        //return Flux.fromIterable(books)
        return books.toFlux() // 코틀린에서 지원하는 Flux 변환을 위한 확장 함수
    }

    fun get(id : Int) : Mono<Book> {
        // return Mono.justOrEmpty(books.find { it.id == id })
        return books.find {it.id == id}.toMono() // 코틀린에서 지원하는 Mono 변환을 위한 확장 함수
    }

    fun add(request : Map<String, Any>) : Mono<Book> {
        return Mono.just(request)
            .map {map ->
                val book = Book(
                    id = nextId.incrementAndGet(),
                    name = map["name"].toString(),
                    price = map["price"] as Int
                )
                books.add(book)
                book
            }
    }

    fun delete(id: Int) : Mono<Void> {
        return Mono.justOrEmpty(books.find { it.id == id })
            .map { books.remove(it) }
            .then()
    }

}