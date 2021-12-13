package com.josecobos.hotelMascotas.service

import com.josecobos.hotelMascotas.model.hospedajeTabla
import com.josecobos.hotelMascotas.repository.hospedajeRepository
import com.josecobos.hotelMascotas.repository.mascotaRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service

class hospedajeService {
    @Autowired
    lateinit var hospedajeRepository: hospedajeRepository
    @Autowired
    lateinit var mascotaRepository: mascotaRepository

    fun list(): List<hospedajeTabla> {

        return hospedajeRepository.findAll()
    }
    fun save(hospedajeTabla: hospedajeTabla):hospedajeTabla{
        try{
            if (hospedajeTabla.fechaingreso?.equals("") == true){
                throw Exception("Fecha de ingreso no puede estar vacio")
            }
            if (hospedajeTabla.numerohabitacion?.equals("") == true){
                throw Exception("El numero de habitacion no puede estar vacio")
            }
            if (hospedajeTabla.mascotaId?.equals("") == true){
                throw Exception("Id de mascota no puede estar vacio")
            }
            mascotaRepository.findById(hospedajeTabla.mascotaId
                ?: throw Exception("No existe la mascota"))
            return hospedajeRepository.save(hospedajeTabla)
        }catch(ex: Exception){
            throw ResponseStatusException(
                HttpStatus.NOT_FOUND, ex.message, ex)
        }

    }

    fun update(hospedajeTabla: hospedajeTabla):hospedajeTabla{
        try{
            if (hospedajeTabla.fechaingreso?.equals("") == true){
                throw Exception("Fecha de ingreso no puede estar vacio")
            }
            if (hospedajeTabla.numerohabitacion?.equals("") == true){
                throw Exception("El numero de habitacion no puede estar vacio")
            }
            if (hospedajeTabla.mascotaId?.equals("") == true){
                throw Exception("Id de mascota no puede estar vacio")
            }
            mascotaRepository.findById(hospedajeTabla.mascotaId
                ?: throw Exception("No existe la mascota"))

            val response = hospedajeRepository.findById(hospedajeTabla.id
                ?: throw Exception("El id ${hospedajeTabla.id} en hospedaje no existe"))
            response.apply{
                fechaingreso=hospedajeTabla.fechaingreso
                fechasalida=hospedajeTabla.fechasalida
                numerohabitacion=hospedajeTabla.numerohabitacion
                mascotaId=hospedajeTabla.mascotaId
            }
            return hospedajeRepository.save(response)
        }catch(ex: Exception){
            throw ResponseStatusException(
                HttpStatus.NOT_FOUND, ex.message, ex)
        }

        return hospedajeRepository.save(hospedajeTabla)
    }

    fun delete (id:Long): Boolean{
        hospedajeRepository.deleteById(id)
        return true
    }
}