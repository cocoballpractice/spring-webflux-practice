

fun main() {
	val mono: Mono<String> = Mono.just("Hello Reactive World")
	mono.subscribe(::println)
}

// 출력 결과
// Hello Reactive World