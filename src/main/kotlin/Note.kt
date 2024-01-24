data class Note(val title: String, val description: String, val type: Type)

enum class Type {
    Audio, Text
}

val list: List<Note> = listOf(
    Note("Title 1", "Description 1", Type.Text),
    Note("Title 2", "Description 2", Type.Text),
    Note("Title 3", "Description 3", Type.Text),
    Note("Title 4", "Description 4", Type.Text),
    Note("Title 5", "Description 5", Type.Text),
    Note("Title 6", "Description 6", Type.Text),
    Note("Title 7", "Description 7", Type.Text),
    Note("Title 8", "Description 8", Type.Text),
    Note("Title 9", "Description 9", Type.Text),
    Note("Title 10", "Description 10", Type.Text)
)
