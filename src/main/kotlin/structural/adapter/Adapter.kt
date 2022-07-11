package structural.adapter

interface Lion {
    fun roar()
}

class AfricanLion: Lion {
    override fun roar() {
        println("African Lion")
    }
}

class AsianLion: Lion {
    override fun roar() {
        println("Asian Lion")
    }
}

class Human {
    fun hunt(lion: Lion) {
        lion.roar()
    }
}

class WildDog {
    fun bark() {
        println("Wild Dog")
    }
}

class WildDogAdapter(private val wildDog: WildDog): Lion {
    override fun roar() {
        wildDog.bark()
    }
}

fun main() {
    val human = Human()
    val africanLion = AfricanLion()

    human.hunt(africanLion)

    val wildDog = WildDog()
    human.hunt(WildDogAdapter(wildDog))
}