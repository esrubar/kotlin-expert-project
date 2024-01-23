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

@Composable // Tienen que tenerlo porque el compilador tiene que pasar por ellos para añadir el codigo necesario
@Preview // Permite previsualizar la app si tienes el plugin "Compose Multiplatform"
fun App() { // Representa a la aplicación
    // mutableStateOf --> así es como se crea un estado
    // la función remember hace que el estado se acuerde que se ha modificado
    val text = remember { mutableStateOf("") }
    var inputText = ""
    MaterialTheme {  // Material es reactivo al estado, cada vez que se modifica un estado, material se actualiza
        Column {
            TextField(value = inputText, onValueChange = {newText ->
                inputText = newText
                text.value = inputText})
            Text(text = "Hello ${text.value}")
            Button(onClick = {
                text.value = ""
                inputText = ""
            }) {
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
