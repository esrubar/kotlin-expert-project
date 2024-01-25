
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Mic
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import kotlin.concurrent.thread

class AppState {
    val state = mutableStateOf(UiState())
    fun loadNotes() {
        thread {
            state.value = UiState(loading = true)
            getNotes { state.value = UiState(notes = it, loading = false) }
        }
    }
    data class UiState(
        val notes: List<Note>? = null,
        val loading: Boolean = false
    )
}

@Composable
@Preview
fun App(appState: AppState) {

    val notes = appState.state.value.notes;
    if(notes == null) {
        LaunchedEffect(true) {
            appState.loadNotes()
        }
    }


    MaterialTheme {
        Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
            if(appState.state.value.loading) {
                CircularProgressIndicator()
            }
            if(notes != null) {
                NotesList(notes)
            }
        }
    }
}

@Composable
private fun NotesList(notes: List<Note>) {
    LazyColumn (
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        items(notes) { note ->
            Card(
                modifier = Modifier.padding(8.dp).fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Row {
                        Text(text = note.title, style = MaterialTheme.typography.h6, modifier = Modifier.weight(1f))
                        if(note.type == Note.Type.AUDIO) {
                            Icon(imageVector = Icons.Default.Mic, contentDescription = null)
                        }
                    }

                    Spacer(modifier = Modifier.height(8.dp))
                    Text(text = note.description)
                }
            }
        }
    }
}

fun main() {
    // Lo que creemos aquí va a vivir toda la vida de la aplicación
    val appState = AppState()
    application {
        Window(onCloseRequest = ::exitApplication) {
            App(appState)
        }
    }
}
