package dev.be.coroutine02

import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

fun sum(a: Int, b: Int) = a + b

fun main() = runBlocking<Unit> {

    // 다른 언어 (JS) 와 달리 키워드가 아닌 함수로 제공
    // Deffered 생략 가능
    val result1 : Deferred<Int> = async {
        delay(100)
        sum(1,3)
    }

    println("result1 : ${result1.await()}")

    val result2 : Deferred<Int> = async {
        delay(100)
        sum(2, 5)
    }

    println("result2 : ${result2.await()}")

}