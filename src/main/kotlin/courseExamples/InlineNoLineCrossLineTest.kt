package courseExamples

/*
* Las funciones inlilne penalizan menos porque se ahorran crear una llamada a otra función
* Noinline -> permite pasar predicados entre funciones
* crossLine: queremos aprovechar las funciones del inline y las de no line
* */
fun test() {
    listOf(1, 3, 4, 5, 6, 8, 10).filter2 { it % 2 == 0 }
}

inline fun List<Int>.filter2(f: (Int) -> Boolean): List<Int> {
    val list = mutableListOf<Int>()
    for (i in this) {
        if (f(i)) {
            list.add(i)
        }
    }
    return list
}