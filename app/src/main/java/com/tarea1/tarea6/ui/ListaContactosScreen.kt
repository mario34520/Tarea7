package com.tarea1.tarea6.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import com.tarea1.tarea6.ui.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.lifecycle.viewmodel.compose.viewModel
import com.tarea1.tarea6.viewmodel.ContactoViewModel
import androidx.compose.runtime.livedata.observeAsState

import com.tarea1.tarea6.Contacto

@Composable
fun ListaContactosScreen(navController: NavHostController, viewModel: ContactoViewModel = viewModel()) {
    val lista by viewModel.contactos.observeAsState(emptyList())

    Column(modifier = Modifier.padding(16.dp)) {
        Text("Lista de Contactos", style = MaterialTheme.typography.headlineSmall)

        Spacer(modifier = Modifier.height(8.dp))

        LazyColumn {
            items(lista) { contacto ->
                Text("${contacto.nombre} ${contacto.apellido} - ${contacto.telefono}")
                Divider()
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = { navController.navigate("agregar_contacto") }) {
            Text("Agregar nuevo contacto")
        }
    }
}
