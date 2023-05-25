package dev.be.coroutine02

import kotlinx.coroutines.runBlocking

fun main() {

    // 코루틴 빌더
    // 내부의 코드는 비동기로 동작하지 않으며 해당 코드가 완료되어야 다음 코드 실행됨
    // 잘 사용하지는 않지만 코루틴을 지원하지 않는 코드 / 특정 라이브러리, 프레임워크를 사용해야 할 때는 감싸줘야 함
    runBlocking {
        println("Hello")
        println(Thread.currentThread().name) // main @coroutine#1
    }

    println("World")
    println(Thread.currentThread().name) // main

}