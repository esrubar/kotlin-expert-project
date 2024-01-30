// Stateflow
// Se utiliza para almacenar un estado y que ese estado se pueda consumir de forma reactiva. Es interesante cuando ese
// estado representa la interfaz
/*
class ViewModel {
    // Backing property. Para que no se pueda settear desde fuera
    private var _state: MutableStateFlow<Note> = MutableStateFlow(Note("title 1", "description 1", Note.Type.TEXT))
    val state: StateFlow<Note> = _state.asStateFlow()

    suspend fun update() {
        var count = 1
        while (true) {
            delay(2000)
            count++
            _state.value = Note("title $count", "description $count", Note.Type.TEXT)
        }
    }
}

fun main(): Unit = runBlocking {
    val viewModel = ViewModel()
    launch {
        viewModel.update()
    }
    viewModel.state.collect(::println)
}

 */