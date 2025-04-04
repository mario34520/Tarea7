package com.tarea1.tarea6

import android.os.Bundle
import com.tarea1.tarea6.ui.*
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.*
import com.tarea1.tarea6.ui.theme.Tarea6Theme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.foundation.layout.padding
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Tarea6Theme {
                MyApp()
            }
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyApp() {
    val navController = rememberNavController()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            DrawerMenu(navController) { scope.launch { drawerState.close() } }
        }
    ) {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            topBar = {
                TopAppBar(
                    title = { Text("Aplicación Multi-Página") },
                    navigationIcon = {
                        IconButton(onClick = { scope.launch { drawerState.open() } }) {
                            Icon(Icons.Filled.Menu, contentDescription = "Menu")
                        }
                    }
                )
            }
        ) { paddingValues ->
            NavigationHost(navController, Modifier.padding(paddingValues))
        }
    }
}

@Composable
fun DrawerMenu(navController: NavHostController, closeDrawer: () -> Unit) {
    Column {
        TextButton(onClick = { navController.navigate("formulario"); closeDrawer() }) {
            Text("Formulario")
        }
        TextButton(onClick = { navController.navigate("detalle"); closeDrawer() }) {
            Text("Detalle")
        }
        TextButton(onClick = { navController.navigate("about"); closeDrawer() }) {
            Text("About")
        }

        // NUEVOS BOTONES PARA CONTACTOS
        TextButton(onClick = { navController.navigate("lista_contactos"); closeDrawer() }) {
            Text("Lista de Contactos")
        }
        TextButton(onClick = { navController.navigate("agregar_contacto"); closeDrawer() }) {
            Text("Agregar Contacto")
        }
    }
}


@Composable
fun NavigationHost(navController: NavHostController, modifier: Modifier) {
    NavHost(navController, startDestination = "formulario", modifier = modifier) {
        composable("formulario") { FormularioScreen() }
        composable("detalle") { DetalleScreen() }
        composable("about") { AboutScreen() }

        // NUEVAS PANTALLAS CON ROOM
        composable("lista_contactos") { ListaContactosScreen(navController) }
        composable("agregar_contacto") { AgregarContactoScreen(navController) }
    }
}

@Composable
fun FormularioScreen() {
    Text("Pantalla de Formulario")
}

@Composable
fun DetalleScreen() {
    Text("Pantalla de Detalle")
}

@Composable
fun AboutScreen() {
    Text("Pantalla About")
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Tarea6Theme {
        MyApp()
    }
}
