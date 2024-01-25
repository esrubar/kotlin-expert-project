data class Note(val title: String, val description: String = "", val type: Type = Type.TEXT) {
    enum class Type {
        AUDIO, TEXT
    }
}

fun getNotes(callback: (List<Note>) -> Unit) {
    Thread.sleep(2000)
    val notes = (1..10).map {
        Note(
            "Title $it",
            "Description $it",
            if (it % 3 == 0) Note.Type.AUDIO else Note.Type.TEXT
        )
    }
    callback(notes)
}

fun createNote() {
    Note(title = "Titulo 1", type = Note.Type.AUDIO)
}