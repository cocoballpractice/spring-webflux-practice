
data class Cellphone(
    val name: String,
    val price : Int,
    val currency: Currency,
)

enum class Currency {
    KRW, USD
}

fun main() {
    val iphone =
        Cellphone(name = "IPhone", price = 100, currency = Currency.KRW)
    val galaxy =
        Cellphone(name = "Galaxy", price = 90, currency = Currency.KRW)

    val flux: Flux<Cellphone> =
        Flux.just(iphone, galaxy)

    flux.subscribe(::println)
}

// 출력 결과
// Cellphone(name=IPhone, price=100, currency=KRW)
// Cellphone(name=Galaxy, price=90, currency=KRW)