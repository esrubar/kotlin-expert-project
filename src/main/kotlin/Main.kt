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

@Composable
@Preview
fun App() {
    val text = remember { mutableStateOf("") }
    fun buildMessage(value: String): String {
        return "Hello $value"
    }
    val buttonEnabled = text.value.isNotEmpty()

    MaterialTheme {
        Column {
            TextField(value = text.value, onValueChange = {newText -> text.value = newText})
            Text(text = buildMessage(text.value))
            Button(onClick = {
                text.value = ""
            }, enabled = buttonEnabled) {
                Text("Clean")
            }
        }
    }
}

fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        App()
    }
}
