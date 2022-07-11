package creational.prototype

interface Prototype<T> {
    fun clone(): T
}

class Sheep(
    val name: String,
    private var age: Int,
): Prototype<Sheep> {

    fun age(): Int = age

    private fun shortAged() { age /= 2 }

    override fun clone(): Sheep = Sheep(this.name, this.age).apply { shortAged() }
}

data class SheepKt(val name: String, val age: Int)

fun main() {
    val dolly = Sheep("Dolly", 20)
    val dollyClone = dolly.clone()

    println("Original Dolly: ${dolly.name}, Age: ${dolly.age()}")
    println("Cloned Dolly: ${dollyClone.name}, Age: ${dollyClone.age()}")

    val dollyKt = SheepKt("Dolly", 20)
    val dollyKtClone = dollyKt.copy(age = dollyKt.age / 2)

    println("Original Dolly: ${dollyKt.name}, Age: ${dollyKt.age}")
    println("Cloned Dolly: ${dollyKtClone.name}, Age: ${dollyKtClone.age}")
}