import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/*
* DIFERENCIA ENTRE SHARED FLOW Y CHANNEL
* - En el shared flow si tenemos varios elementos escuchando o recolectando, todos ellos van a recibir las actualizaciones
* - Los channels están pensados para que solo haya un recolector, por lo tanto solo uno de ellos recibirá la información
*
* En este caso, por defecto, hasta que no se consume el mensaje anterior, no se puede enviar uno nuevo
*/

class ViewModel3 {
    private val _state = Channel<Note>()
    val state = _state.receiveAsFlow()

    suspend fun update() {
        var count = 1
        while (true) {
            delay(2000)
            count++
            _state.send(Note("title $count", "description $count", Note.Type.TEXT))
        }
    }
}

fun main(): Unit = runBlocking {
    val viewModel = ViewModel2()
    launch {
        viewModel.update()
    }
    delay(2000)
    viewModel.state.collect(::println)
}