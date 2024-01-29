
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Mic
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

fun <T> MutableState<T>.update(produceValue: (T) -> T) {
    value = produceValue(value)
}
@Composable
@Preview
fun App(): Unit = with(AppState) {

    val notes = state.notes;
    if(notes == null) {
        LaunchedEffect(true) {
            loadNotes(this)
        }
    }


    MaterialTheme {
        Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
            if(state.loading) {
                CircularProgressIndicator()
            }
            /*
            if(notes != null) {
                NotesList(notes)
            }
            =
             */
            notes?.let { NotesList(it) }
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

class Database

fun main() {

    val db by lazy { Database() }

    application {
        Window(onCloseRequest = ::exitApplication) {
            App()
        }
    }
}
