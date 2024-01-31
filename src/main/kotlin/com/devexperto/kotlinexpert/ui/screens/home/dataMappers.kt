package com.devexperto.kotlinexpert.ui.screens.home

/* Alias solo para esta clase
import com.devexperto.kotlinexpert.data.Note as DataNote
import com.devexperto.kotlinexpert.ui.Note as UiNote
*/

// Alias que se pueden usar en toda la app
typealias DataNote = com.devexperto.kotlinexpert.data.Note
typealias UiNote = com.devexperto.kotlinexpert.data.Note


// Alias
fun UiNote.toUiNote(note: DataNote): UiNote = UiNote(note.title)