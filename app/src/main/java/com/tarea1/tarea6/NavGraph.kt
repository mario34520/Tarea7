package com.tarea1.tarea6

import com.tarea1.tarea6.ui.*
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun AppNavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "lista") {
        composable("lista") {
            ListaContactosScreen(navController)
        }
        composable("agregar") {
            AgregarContactoScreen(navController)
        }
    }
}

