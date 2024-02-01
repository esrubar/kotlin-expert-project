package courseExamples

fun RefiedTest() {
    listOf(20, "String", 20f, 5, 8L, 20.0, "String2").filterIsInstance2<String>()
}

inline fun <reified T> List<Any>.filterIsInstance2(): List<T> {
    val res = mutableListOf<T>()
    for (item in this) {
        if (item is T) {
            res.add(item)
        }
    }
    return res
}