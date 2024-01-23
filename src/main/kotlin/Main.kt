import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

class AppState {
    val text =  mutableStateOf("")
    //Opción 1
    fun isButtonEnabled() = text.value.isNotEmpty()

    //Opción 2
    val buttonEnabled: Boolean
        get() = text.value.isNotEmpty()
}

@Composable
@Preview
fun App(appState: AppState) {
    MaterialTheme {
        Column {
            TextField(value = appState.text.value, onValueChange = {newText -> appState.text.value = newText})
            Text(text = buildMessage(appState.text.value))
            Button(onClick = {
                appState.text.value = ""
            }, enabled = appState.buttonEnabled) {
                Text("Clean")
            }
        }
    }
}
fun buildMessage(value: String) = "Hello $value"

fun main() {
    // Lo que creemos aquí va a vivir toda la vida de la aplicación
    val appState = AppState()
    application {
        Window(onCloseRequest = ::exitApplication) {
            App(appState)
        }
    }
}
