package dev.be.webclient

import dev.be.book.Book
import org.slf4j.LoggerFactory
import org.springframework.core.ParameterizedTypeReference
import org.springframework.http.HttpMethod
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.RestTemplate
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Flux

@RestController
class WebClientExample {

    // 기존 RestTemplate의 경우 스프링 5.0부터 deprecated되었음
    // MVC, WebFlux 모두 WebClient를 사용하는 것을 권장
    // 기존 RestTemplate의 문제점 : exchange 호출 시 응답을 받을 때까지 스레드가 블로킹됨
    // WebClient : 비동기 - 논블로킹 방식이며 RestTemplate 보다 부하를 줄일 수 있음 (컨텍스트 스위칭 적음, 별도의 대기 시간 없음 등)

    val url = "http://localhost:8080/books"

    val log = LoggerFactory.getLogger(javaClass)

    @GetMapping("/books/block")
    fun getBooksBlockingWay() : List<Book> {
        log.info("Start RestTemplate")

        val restTemplate = RestTemplate()
        val response = restTemplate.exchange(url, HttpMethod.GET, null,
            object : ParameterizedTypeReference<List<Book>>() {}
            )

        val result = response.body!!
        log.info("result : {}", result)
        log.info("Finish RestTemplate")
        return result
    }

    @GetMapping("/books/nonblock")
    fun getBooksNonBlockingWay() : Flux<Book> {
        log.info("Start WebClient")

        val flux = WebClient.create()
            .get()
            .uri(url)
            .retrieve()
            .bodyToFlux(Book::class.java)
            .map {
                log.info("result : {}", it)
                it
            }

        log.info("Finish WebClient")
        return flux
    }

}