package courseExamples

data class Note(val title: String, val description: String = "", val type: Type = Type.TEXT) {
    enum class Type {
        AUDIO, TEXT
    }
}

operator fun Note.plus(other: Note): Note = Note(title, "$description &(other.description)", type)
fun test(note1: Note, note2: Note) = note1 + note2
fun test2(notes: List<Note>, note: Note) = notes + note