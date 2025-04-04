package com.tarea1.tarea6.ui.componentes

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun BotonGuardar(texto: String = "Guardar", onClick: () -> Unit) {
    Button(onClick = onClick) {
        Text(text = texto)
    }
}
