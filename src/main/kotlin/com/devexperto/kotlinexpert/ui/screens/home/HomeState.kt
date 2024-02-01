package com.devexperto.kotlinexpert.ui.screens.home

import com.devexperto.kotlinexpert.data.Filter
import com.devexperto.kotlinexpert.data.Note
import com.devexperto.kotlinexpert.data.fakeNotes
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlin.reflect.KProperty

operator fun <T> StateFlow<T>.getValue(owner: Any?, property: KProperty<*>): T = this.value
operator fun <T> MutableStateFlow<T>.setValue(owner: Any?, property: KProperty<*>, newValue: T) {
    this.value = newValue
}

object HomeState {
    //private var _state = MutableStateFlow(UiState())
    //val state = _state.asStateFlow()

    var state: UiState by MutableStateFlow(UiState())
        private set

    fun loadNotes(coroutineScope: CoroutineScope) {
        coroutineScope.launch {
            state = UiState(loading = true)
            Note.fakeNotes.collect {
                state = UiState(notes = it)
            }

        }
    }

    fun onFilterClick(filter: Filter) {
        state = state.copy(filter = filter)
    }

    data class UiState(
        val notes: List<Note>? = null,
        val loading: Boolean = false,
        val filter: Filter = Filter.All
    ) {
        val filterNotes: List<DataNote>?
            get() = when (filter) {
                Filter.All -> notes
                is Filter.ByType -> notes?.filter { it.type == filter.type }
            }
    }
}