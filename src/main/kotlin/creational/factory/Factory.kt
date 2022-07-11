package creational.factory

interface Door {
    fun getWidth(): Float
    fun getHeight(): Float
}

class WoodenDoor(
    private val width: Float,
    private val height: Float,
): Door {
    override fun getWidth(): Float = width

    override fun getHeight(): Float = height
}

object DoorFactory {
    fun makeDoor(width: Float, height: Float): Door {
        return WoodenDoor(width, height)
    }
}

fun main() {
    val door = DoorFactory.makeDoor(10f, 10f)

    println("Width: ${door.getWidth()}, Height: ${door.getHeight()}")
}