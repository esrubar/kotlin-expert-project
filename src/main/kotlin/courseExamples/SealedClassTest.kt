package courseExamples

sealed class CanWalk(val legs: Int)
sealed interface CanFly
/*
* Ventaja de las clases sealed. Que pueden tener su propio estado
* Siempre que se pueda, lo interesante es unsar una sealed Interface, pero lo malo que tienen es que no pueden almacenar
* estados (parámetros)*/

class Elephant(val name: String) : CanWalk(4)
class Spider(val age: Int) : CanWalk(8)
object Swan : CanWalk(2), CanFly
object Fly : CanFly

fun test(canWalk: CanWalk): Int = when (canWalk) {
    is Elephant -> canWalk.name.toInt()
    is Spider -> TODO()
    is Swan -> TODO()
}

fun test2(canFly: CanFly): Int = when (canFly) {
    Fly -> TODO()
    Swan -> TODO()
}