package com.tarea1.tarea6

import androidx.room.*

@Dao
interface ContactoDao {
    @Query("SELECT * FROM contacto")
    suspend fun obtenerTodos(): List<Contacto>

    @Insert
    suspend fun insertar(contacto: Contacto)

    @Delete
    suspend fun eliminar(contacto: Contacto)

    @Update
    suspend fun actualizar(contacto: Contacto)
}
