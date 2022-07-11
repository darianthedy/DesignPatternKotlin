package creational.abstractfactory

interface Door {
    fun getDescription()
}

class WoodenDoor: Door {
    override fun getDescription() {
        println("Wooden Door")
    }
}

class IronDoor: Door {
    override fun getDescription() {
        println("Iron Door")
    }
}

interface DoorExpert {
    fun getDescription()
}

class Carpenter: DoorExpert {
    override fun getDescription() {
        println("Carpenter for wooden door")
    }
}

class Welder: DoorExpert {
    override fun getDescription() {
        println("Welder for iron door")
    }
}

interface DoorFactory {
    fun makeDoor(): Door
    fun makeExpert(): DoorExpert
}

class WoodenDoorFactory(): DoorFactory {
    override fun makeDoor(): Door = WoodenDoor()

    override fun makeExpert(): DoorExpert = Carpenter()
}

class IronDoorFactory(): DoorFactory {
    override fun makeDoor(): Door = IronDoor()

    override fun makeExpert(): DoorExpert = Welder()
}

fun main() {
    val woodenDoorFactory = WoodenDoorFactory()
    printDoor(woodenDoorFactory)

    val ironDoorFactory = IronDoorFactory()
    printDoor(ironDoorFactory)
}

fun printDoor(doorFactory: DoorFactory) {
    val door = doorFactory.makeDoor()
    val expert = doorFactory.makeExpert()

    door.getDescription()
    expert.getDescription()
}