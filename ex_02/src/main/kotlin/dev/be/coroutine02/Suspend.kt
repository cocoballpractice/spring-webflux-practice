package dev.be.coroutine02

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

fun main() {
    // doSomething() // 서스펜드 함수 호출 어려움, main()이 suspend 함수여야 하거나 runBlocking을 사용해야 함
}

fun printHello() = println("hello")

// 일시 중단 - 재개가 가능한 함수
// 서스펜드 - 일반 함수 호출은 가능하나 일반 함수 - 서스펜드 함수는 직접 호출이 어려움 (똑같이 서스펜드 함수여아 하거나, runBlocking을 사용해야 함)
// coroutineScope = runBlocking과 달리 현재 스레드가 차단되지 않고 동작됨
suspend fun doSomething() = coroutineScope {

    launch {
        delay(200)
        println("world")
    }

    launch {
        printHello() // 일반 함수 호출 자유
    }
}