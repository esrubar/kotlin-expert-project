package courseExamples

import kotlin.reflect.KProperty

class Owner {
    val lazyProperty: Int by lazy2 { 20 }
}

fun <T> lazy2(producer: () -> T) = MyLazy(producer)

class MyLazy<T>(private val producer: () -> T) {
    private var lazyObj: T? = null

    operator fun getValue(owner: Any?, property: KProperty<*>): T {
        if (lazyObj == null) {
            lazyObj = producer()
        }

        return lazyObj!!
    }

    operator fun setValue(owner: Any?, property: KProperty<*>, newValue: T) {
        lazyObj = newValue
    }
}