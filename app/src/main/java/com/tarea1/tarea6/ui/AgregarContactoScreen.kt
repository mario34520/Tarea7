package com.tarea1.tarea6.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.tarea1.tarea6.ui.*
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.tarea1.tarea6.viewmodel.ContactoViewModel
import com.tarea1.tarea6.Contacto
import com.tarea1.tarea6.ui.componentes.CajaTexto
import com.tarea1.tarea6.ui.componentes.BotonGuardar

@Composable
fun AgregarContactoScreen(navController: NavHostController, viewModel: ContactoViewModel = viewModel()) {
    var nombre by remember { mutableStateOf("") }
    var apellido by remember { mutableStateOf("") }
    var telefono by remember { mutableStateOf("") }

    Column(modifier = Modifier
        .padding(16.dp)
        .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text("Nuevo Contacto", style = MaterialTheme.typography.headlineSmall)

        CajaTexto(valor = nombre, onValorCambiado = { nombre = it }, etiqueta = "Nombre")
        CajaTexto(valor = apellido, onValorCambiado = { apellido = it }, etiqueta = "Apellido")
        CajaTexto(valor = telefono, onValorCambiado = { telefono = it }, etiqueta = "Teléfono")

        BotonGuardar("Guardar") {
            val contacto = Contacto(nombre = nombre, apellido = apellido, telefono = telefono)
            viewModel.agregar(contacto)
            navController.popBackStack() // regresa a la lista
        }
    }
}
