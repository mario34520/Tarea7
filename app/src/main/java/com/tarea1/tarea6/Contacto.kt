package com.tarea1.tarea6

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "contacto")
data class Contacto(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val nombre: String,
    val apellido: String,
    val telefono: String
)
