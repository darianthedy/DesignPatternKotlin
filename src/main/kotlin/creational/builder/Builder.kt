package creational.builder

class Burger(builder: Builder) {

    val size: Int = builder.size
    val cheese: Boolean = builder.cheese
    val pepperoni: Boolean = builder.pepperoni

    fun show() {
        println("Burger size: $size, has cheese: $cheese, has pepperoni: $pepperoni")
    }

    class Builder(
        val size: Int,
    ) {
        var cheese: Boolean = false; private set

        var pepperoni: Boolean = false; private set

        fun addCheese(): Builder = apply { cheese = true }

        fun addPepperoni(): Builder = apply { pepperoni = true }

        fun build(): Burger = Burger(this)
    }
}

fun burger(size: Int, block: Burger.Builder.() -> Unit) =
    Burger.Builder(size).apply(block).build()

fun main() {
    val burger = Burger.Builder(10)
        .addCheese()
        .addPepperoni()
        .build()

    burger.show()

    val burger2 = burger(20) {
        addPepperoni()
        addCheese()
    }

    burger2.show()
}