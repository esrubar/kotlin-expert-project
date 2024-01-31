package courseExamples

data class Person(val name: String)
data class Cow(val name: String)

var p: Person = Person("Tom")

fun advancedTypesFun() {
    val res: String = when (p.name[0]) {
        'T' -> "T"
        'A' -> "A"
        else -> return
    }
    println(res)
}

fun advancedTypesFun2(x: Int?) {
    val l: Long = x?.toLong() ?: throw IllegalStateException()
    println(l)
}

