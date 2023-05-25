package dev.be.coroutine02

import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

fun main() {

    runBlocking<Unit> {

        // 스레드 차단 없이 새 코루틴을 시작하고 결과로 Job을 반환하는 코루틴 빌더
        launch {
            delay(500) // 코루틴에서 정의된 일시 중단 함수, 스레드를 차단시키지는 않는다
            println("World!")
        }

    }

    println("Hello")

    // Hello
    // World!


    runBlocking<Unit> {

        val job1 : Job = launch {
            val elapsedTime = measureTimeMillis {
                delay(150)
            }
            println("async task-1 $elapsedTime ms")
        }
        job1.cancel()

        // job이 start 되어야 실행됨
        val job2 : Job = launch(start = CoroutineStart.LAZY) {
            val elapsedTime = measureTimeMillis {
                delay(100)
            }
            println("async task-2 $elapsedTime ms")
        }

        println("start task-2")

        job2.start()
    }

}