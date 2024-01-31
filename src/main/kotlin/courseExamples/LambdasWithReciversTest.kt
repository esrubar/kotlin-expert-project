package courseExamples

// Lambdas con recivers
fun foo(f: String.() -> String) {}
fun String.toUpperCase() = uppercase() //=  this.uppercase()

fun test2() {
    foo {
        this.toUpperCase()
    }
}