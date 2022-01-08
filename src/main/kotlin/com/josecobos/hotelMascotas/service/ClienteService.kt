package com.josecobos.hotelMascotas.service

import com.josecobos.hotelMascotas.model.ClienteTabla
import com.josecobos.hotelMascotas.repository.ClienteRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service

class ClienteService {
    @Autowired
    lateinit var clienteRepository:ClienteRepository


    fun list(): List<ClienteTabla> {

        return clienteRepository.findAll()
    }
    fun save(clienteTabla: ClienteTabla):ClienteTabla{
        try{
            if (clienteTabla.nombre?.equals("") == true){
                throw Exception("Nombre no puede estar vacio")
            }
            if (clienteTabla.apellido?.equals("") == true){
                throw Exception("Apellido no puede estar vacio")
            }
            if (clienteTabla.cedula?.equals("") == true){
                throw Exception("Cedula no puede estar vacio")
            }
            if (clienteTabla.correo?.equals("") == true){
                throw Exception("Correo no puede estar vacio")
            }
            if (clienteTabla.telefono?.equals("") == true){
                throw Exception("Telefono no puede estar vacio")
            }
            if (clienteTabla.direccion?.equals("") == true){
                throw Exception("Direccion no puede estar vacio")
            }
            return clienteRepository.save(clienteTabla)
        }catch(ex: Exception){
            throw ResponseStatusException(
                HttpStatus.NOT_FOUND, ex.message, ex)
        }

    }

    fun update(clienteTabla: ClienteTabla):ClienteTabla{
        try{
            if (clienteTabla.nombre?.equals("") == true){
                throw Exception("Nombre no puede estar vacio")
            }
            if (clienteTabla.apellido?.equals("") == true){
                throw Exception("Apellido no puede estar vacio")
            }
            if (clienteTabla.cedula?.equals("") == true){
                throw Exception("Cedula no puede estar vacio")
            }
            if (clienteTabla.correo?.equals("") == true){
                throw Exception("Correo no puede estar vacio")
            }
            if (clienteTabla.telefono?.equals("") == true){
                throw Exception("Telefono no puede estar vacio")
            }
            if (clienteTabla.direccion?.equals("") == true){
                throw Exception("Direccion no puede estar vacio")
            }
            val response = clienteRepository.findById(clienteTabla.id)
                ?: throw Exception("El id ${clienteTabla.id} en clientes no existe")
            response.apply{
                nombre = clienteTabla.nombre
                apellido = clienteTabla.apellido
                cedula = clienteTabla.cedula
                correo = clienteTabla.correo
                telefono = clienteTabla.telefono
                direccion = clienteTabla.direccion
            }
            return clienteRepository.save(response)
        }catch(ex: Exception){
            throw ResponseStatusException(
                HttpStatus.NOT_FOUND, ex.message, ex)
        }
    }
    fun updateDescription (clienteTabla: ClienteTabla):ClienteTabla {
        try{
            if (clienteTabla.nombre?.equals("") == true){
                throw Exception("Nombre no puede estar vacio")
            }
            if (clienteTabla.apellido?.equals("") == true){
                throw Exception("Apellido no puede estar vacio")
            }
            if (clienteTabla.cedula?.equals("") == true){
                throw Exception("Cedula no puede estar vacio")
            }
            if (clienteTabla.correo?.equals("") == true){
                throw Exception("Correo no puede estar vacio")
            }
            if (clienteTabla.telefono?.equals("") == true){
                throw Exception("Telefono no puede estar vacio")
            }
            if (clienteTabla.direccion?.equals("") == true){
                throw Exception("Direccion no puede estar vacio")
            }
            val response = clienteRepository.findById(clienteTabla.id)
                ?: throw Exception("El id ${clienteTabla.id} en clientes no existe")
            response.apply{
                nombre = clienteTabla.nombre
                apellido = clienteTabla.apellido
                cedula = clienteTabla.cedula
                correo = clienteTabla.correo
                telefono = clienteTabla.telefono
                direccion = clienteTabla.direccion
            }
            return clienteRepository.save(response)
        }
        catch (ex: Exception) {
            throw ResponseStatusException(
                HttpStatus.NOT_FOUND, ex.message, ex)
        }
    }

    fun delete (id:Long): Boolean{
        clienteRepository.deleteById(id)
        return true
    }
}