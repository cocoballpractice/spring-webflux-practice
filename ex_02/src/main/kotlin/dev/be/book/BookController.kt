package dev.be.book

import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
class BookController(
    private val bookService: BookService,
) {

    @GetMapping("/books")
    fun getAll() : Flux<Book> {
        return bookService.getAll() // 반환 타입이 Mono, Flux일 경우 subscribe() 필요하지만 생략해도 됨 (스프링이 자동으로 처리)
    }

    @GetMapping("/books/{id}")
    fun get(@PathVariable id: Int) : Mono<Book> {
        return bookService.get(id) // 반환 타입이 Mono, Flux일 경우 subscribe() 필요하지만 생략해도 됨 (스프링이 자동으로 처리)
    }

    @PostMapping("/books")
    fun add(@RequestBody request : Map<String, Any>) : Mono<Book> {
        return bookService.add(request) // 반환 타입이 Mono, Flux일 경우 subscribe() 필요하지만 생략해도 됨 (스프링이 자동으로 처리)
    }

    @DeleteMapping("/books/{id}")
    fun delete(@PathVariable id : Int) : Mono<Void> {
        return bookService.delete(id)
    }

}