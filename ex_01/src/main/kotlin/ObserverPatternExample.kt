import java.util.*

class Coffee(val name: String)

// subject
class Barista : Observable() {

    private lateinit var coffeeName: String

    fun orderCoffee(name: String) {
        this.coffeeName = name
    }

    fun makeCoffee() {
        setChanged()
        notifyObservers(Coffee(this.coffeeName))
    }

}

// observer
class Customer(val name: String) : Observer {

    override fun update(o: Observable?, arg: Any?) {
        val coffee = arg as Coffee
        println("${name}이 ${coffee.name}을 받았습니다.")
    }

}

fun main() {

    val barista = Barista()
    barista.orderCoffee("아이스 아메리카노")

    val customer = Customer("고객 1")

    barista.addObserver(customer)

    barista.makeCoffee() // Observer의 update 함수가 실행됨

}