import java.util.concurrent.Callable
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit

fun sum(a: Int, b: Int) = a+b

fun main() {
    val pool = Executors.newSingleThreadExecutor()
    val future = pool.submit(Callable {
        sum(100, 200)
    })

    println("계산 시작")
    val futureResult = future.get(1000L, TimeUnit.MILLISECONDS) // 비동기 작업의 결과를 기다림
    println(futureResult)
    println("계산 종료") // TimeOut을 지정해주지 않으면 무한정 대기
}