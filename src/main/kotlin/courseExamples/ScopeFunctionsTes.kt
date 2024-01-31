package courseExamples

// Implementación de scope functions

//With
fun WithTest() {
    val x: Int = with2("Hello") {
        println(this.uppercase())
        20
    }
}

fun <T, R> with2(receiver: T, block: T.() -> R): R = receiver.block()

// Run
fun RunTest() {
    val x: Int = "Hello".run2 {
        println(this.uppercase())
        20
    }
}

fun <T, R> T.run2(block: T.() -> R): R = block()

// Apply
fun ApplyTest() {
    val x: String = "Hello".apply2 {
        println(this.uppercase())
    }
}

fun <T> T.apply2(block: T.() -> Unit): T {
    this.block()
    return this
}

// Also
fun AlsoTest() {
    val x: String = "Hello".also2 {
        println(it.uppercase())
    }
}

fun <T> T.also2(block: (T) -> Unit): T {
    block(this)
    return this
}

// Let
fun LetTest() {
    val x: Int = "Hello".let2 {
        println(it.uppercase())
        29
    }
}

fun <T, R> T.let2(block: (T) -> R): R = block(this)