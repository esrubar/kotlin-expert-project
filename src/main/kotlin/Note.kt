import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

data class Note(val title: String, val description: String = "", val type: Type = Type.TEXT) {
    enum class Type {
        AUDIO, TEXT
    }
}

fun getNotes(): Flow<List<Note>> = flow {
    delay(200)
    var notes = emptyList<Note>()
    (0..10).forEach {
        notes = notes +
                Note(
                    "Title $it",
                    "Description $it",
                    if (it % 3 == 0) Note.Type.AUDIO else Note.Type.TEXT
                )
        emit(notes)
        delay(500)
    }
}

fun createNote() {
    Note(title = "Titulo 1", type = Note.Type.AUDIO)
}