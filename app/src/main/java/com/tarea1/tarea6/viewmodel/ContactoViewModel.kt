package com.tarea1.tarea6.viewmodel

import android.app.Application
import androidx.lifecycle.*
import com.tarea1.tarea6.Contacto
import com.tarea1.tarea6.ContactoDatabase
import kotlinx.coroutines.launch

class ContactoViewModel(application: Application) : AndroidViewModel(application) {

    private val contactoDao = ContactoDatabase.getDatabase(application).contactoDao()
    private val _contactos = MutableLiveData<List<Contacto>>()
    val contactos: LiveData<List<Contacto>> = _contactos

    init {
        cargarContactos()
    }

    fun cargarContactos() {
        viewModelScope.launch {
            _contactos.value = contactoDao.obtenerTodos()
        }
    }

    fun agregar(contacto: Contacto) {
        viewModelScope.launch {
            contactoDao.insertar(contacto)
            cargarContactos()
        }
    }

    fun eliminar(contacto: Contacto) {
        viewModelScope.launch {
            contactoDao.eliminar(contacto)
            cargarContactos()
        }
    }

    fun actualizar(contacto: Contacto) {
        viewModelScope.launch {
            contactoDao.actualizar(contacto)
            cargarContactos()
        }
    }
}
