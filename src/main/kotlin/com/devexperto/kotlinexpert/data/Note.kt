package com.devexperto.kotlinexpert.data

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow

data class Note(val title: String, val description: String = "", val type: Type = Type.TEXT) {
    enum class Type {
        AUDIO, TEXT
    }

    companion object
}

val Note.Companion.fakeNotes
    get() = flow {
        delay(200)
        val notes = (0..10).map {
            Note(
                "Title $it",
                "Description $it",
                if (it % 3 == 0) Note.Type.AUDIO else Note.Type.TEXT
            )
        }
        emit(notes)
    }

fun createNote() {
    Note(title = "Titulo 1", type = Note.Type.AUDIO)
}