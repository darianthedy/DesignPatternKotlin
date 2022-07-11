package creational.singleton

class President private constructor() {
    companion object {
        private lateinit var instance: President

        fun getInstance(): President {
            if (!::instance.isInitialized) {
                instance = President()
            }

            return instance
        }
    }

    var name: String = "President"
}

object PresidentKt {
    var name: String = "President"
}

fun main() {
//    val createPresidentNotAllowed = President()
    println("President Name: ${President.getInstance().name}")

    val presidentKt = PresidentKt
    println("PresidentKt Name: ${PresidentKt.name}")
}