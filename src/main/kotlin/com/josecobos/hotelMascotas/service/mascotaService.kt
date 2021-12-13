package com.josecobos.hotelMascotas.service

import com.josecobos.hotelMascotas.model.mascotaTabla
import com.josecobos.hotelMascotas.repository.clienteRepository
import com.josecobos.hotelMascotas.repository.mascotaRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service

class mascotaService {
    @Autowired
    lateinit var mascotaRepository: mascotaRepository
    @Autowired
    lateinit var clienteRepository: clienteRepository


    fun list(): List<mascotaTabla> {

        return mascotaRepository.findAll()
    }
    fun save(mascotaTabla: mascotaTabla):mascotaTabla{
        try{
            if (mascotaTabla.nombre?.equals("") == true){
                throw Exception("Nombre no puede estar vacio")
            }
            if (mascotaTabla.tipo?.equals("") == true){
                throw Exception("Tipo no puede estar vacio")
            }
            if (mascotaTabla.raza?.equals("") == true){
                throw Exception("Raza no puede estar vacio")
            }
            if (mascotaTabla.edad?.equals("") == true){
                throw Exception("Edad no puede estar vacio")
            }
            if (mascotaTabla.tipocomida?.equals("") == true){
                throw Exception("Comida no puede estar vacio")
            }
            if (mascotaTabla.clienteId?.equals("") == true){
                throw Exception("Cliente no puede estar vacio")
            }
            clienteRepository.findById(mascotaTabla.clienteId
                ?: throw Exception("No existe el cliente"))

            return mascotaRepository.save(mascotaTabla)
        }catch(ex: Exception){
            throw ResponseStatusException(
                HttpStatus.NOT_FOUND, ex.message, ex)
        }

    }

    fun update(mascotaTabla: mascotaTabla):mascotaTabla{
        try{
            if (mascotaTabla.nombre?.equals("") == true){
                throw Exception("Nombre no puede estar vacio")
            }
            if (mascotaTabla.tipo?.equals("") == true){
                throw Exception("Tipo no puede estar vacio")
            }
            if (mascotaTabla.raza?.equals("") == true){
                throw Exception("Raza no puede estar vacio")
            }
            if (mascotaTabla.edad?.equals("") == true){
                throw Exception("Edad no puede estar vacio")
            }
            if (mascotaTabla.tipocomida?.equals("") == true){
                throw Exception("Comida no puede estar vacio")
            }
            if (mascotaTabla.clienteId?.equals("") == true){
                throw Exception("Cliente no puede estar vacio")
            }
            clienteRepository.findById(mascotaTabla.clienteId
                ?: throw Exception("No existe el cliente"))

            val response = mascotaRepository.findById(mascotaTabla.id
                ?: throw Exception("El id ${mascotaTabla.id} en mascota no existe"))
            response.apply{
               nombre=mascotaTabla.nombre
                tipo=mascotaTabla.tipo
                raza = mascotaTabla.raza
                edad= mascotaTabla.edad
                tipocomida=mascotaTabla.tipocomida
                enfermedades=mascotaTabla.enfermedades
                clienteId=mascotaTabla.clienteId
            }
            return mascotaRepository.save(response)
        }catch(ex: Exception){
            throw ResponseStatusException(
                HttpStatus.NOT_FOUND, ex.message, ex)
        }
    }

    fun delete (id:Long): Boolean{
        mascotaRepository.deleteById(id)
        return true
    }
}