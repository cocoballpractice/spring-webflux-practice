package dev.be.coroutine02

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking

// flow : 코루틴에서 리액티브 프로그래밍 스타일로 작성할 수 있도록 만들어진 API
fun main() = runBlocking<Unit> {

    val flow = simple()
    flow.collect{ value -> println(value)} // collect : Terminal Operator, 없을 경우 작동이 안됨

}

fun simple() : Flow<Int> = flow{
    println("Flow started")

    for (i in 1..3) {
        delay(100)
        emit(i) // 메시지를 통지
    }
}