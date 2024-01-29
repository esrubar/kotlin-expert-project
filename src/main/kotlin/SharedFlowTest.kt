import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/*
* StateFlow es una especialización de SharedFlow que es mucho mas configurable
* Estás generando valores pero no te interesa mas allá de determinado número de valores específicos que el consumidor
* los reciba
* DIFERENCIA ENTRE SHARED FLOW Y CHANNEL
* - En el shared flow si tenemos varios elementos escuchando o recolectando, todos ellos van a recibir las actualizaciones
* - Los channels están pensados para que solo haya un recolector, por lo tanto solo uno de ellos recibirá la información
*/

class ViewModel2 {
    private var _state =
        MutableSharedFlow<Note>(replay = 3, extraBufferCapacity = 3, onBufferOverflow = BufferOverflow.DROP_LATEST)
    val state = _state.asSharedFlow()

    suspend fun update() {
        var count = 1
        while (true) {
            delay(2000)
            count++
            _state.emit(Note("title $count", "description $count", Note.Type.TEXT))
        }
    }
}

fun main(): Unit = runBlocking {
    val viewModel = ViewModel2()
    launch {
        viewModel.update()
    }
    viewModel.state.collect(::println)
}