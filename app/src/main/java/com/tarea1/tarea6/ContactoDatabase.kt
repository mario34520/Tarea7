package com.tarea1.tarea6

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Contacto::class], version = 1)
abstract class ContactoDatabase : RoomDatabase() {
    abstract fun contactoDao(): ContactoDao

    companion object {
        @Volatile
        private var INSTANCE: ContactoDatabase? = null

        fun getDatabase(context: Context): ContactoDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ContactoDatabase::class.java,
                    "contacto_db"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
