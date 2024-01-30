import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

// Flows. Por defecto colds
/* Cualquier cosa que tarde un tiempo, puede quedarse aquí esperando */
fun main(): Unit = runBlocking {
    val res = flow {
        emit(1)
        delay(200)
        emit(2)
        delay(200)
        emit(3)
    }.transform {
        // Para transformaciones mas complejas, puede ser interesante
        if (it % 2 == 0) emit("Item $it")
    }
    delay(2000)
    // Los valores no empiezan a emitirse hasta que no empezamos a recolectarlos
    // Si metemos el collect en un launch se van ejecutando alternamente
    launch {
        res.collect {
            println(it)
        }
    }
    launch {
        res.collect {
            println(it)
        }
    }

    // ------------
    val flow1 = flowOf(1, 2, 3, 4).onEach { delay(300) }
    val flow2 = flowOf("a", "b", "c").onEach { delay(500) }
    flow1.zip(flow2) { a, b -> "$a -> $b" }.collect { println(it) }
    flow1.combine(flow2) { a, b -> "$a -> $b" }
        .collect { println(it) } // Se llama a esta función con el ultimo valor generado

    // collect es una operación terminal, como toList. Se esperan a que tengamos todos los valores para emitir una lista
    // con ellos

    // ------------
    // En los flows no se puede cambiar de contexto.
    // flowOn() te permite cambiar el contexto. Hace que sea el consumidor
    // del flow el que decide en que dispatcher ejecutarse
    val flow3 = flow {
        emit(2)
    }
    flow3
        .flowOn(Dispatchers.IO)
        .catch { throwable -> println(throwable.message) } // Recoge la excepción
        .collect {
            println(it)
        }
}