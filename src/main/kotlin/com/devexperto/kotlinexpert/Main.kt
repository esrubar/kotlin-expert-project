package com.devexperto.kotlinexpert

import androidx.compose.runtime.MutableState
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.devexperto.kotlinexpert.ui.App

fun <T> MutableState<T>.update(produceValue: (T) -> T) {
    value = produceValue(value)
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
