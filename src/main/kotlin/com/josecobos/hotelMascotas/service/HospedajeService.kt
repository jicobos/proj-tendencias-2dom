package com.josecobos.hotelMascotas.service

import com.josecobos.hotelMascotas.model.HospedajeTabla
import com.josecobos.hotelMascotas.repository.HospedajeRepository
import com.josecobos.hotelMascotas.repository.MascotaRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service

class HospedajeService {
    @Autowired
    lateinit var hospedajeRepository: HospedajeRepository
    @Autowired
    lateinit var mascotaRepository: MascotaRepository

    fun list(): List<HospedajeTabla> {

        return hospedajeRepository.findAll()
    }
    fun save(hospedajeTabla: HospedajeTabla):HospedajeTabla{
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

    fun update(hospedajeTabla: HospedajeTabla):HospedajeTabla{
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

            val response = hospedajeRepository.findById(hospedajeTabla.id)
                ?: throw Exception("El id ${hospedajeTabla.id} en hospedaje no existe")
            response.apply {
            fechaingreso = hospedajeTabla.fechaingreso
            fechasalida = hospedajeTabla.fechasalida
            numerohabitacion = hospedajeTabla.numerohabitacion
            mascotaId =hospedajeTabla.mascotaId
        }
            return hospedajeRepository.save(response)
        }catch(ex: Exception){
            throw ResponseStatusException(
                HttpStatus.NOT_FOUND, ex.message, ex)
        }
    }

    fun updateDescription(hospedajeTabla: HospedajeTabla):HospedajeTabla{
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

            val response = hospedajeRepository.findById(hospedajeTabla.id)
                ?: throw Exception("El id ${hospedajeTabla.id} en hospedaje no existe")
            response.apply {
                fechaingreso = hospedajeTabla.fechaingreso
                fechasalida = hospedajeTabla.fechasalida
                numerohabitacion = hospedajeTabla.numerohabitacion
                mascotaId =hospedajeTabla.mascotaId
            }
            return hospedajeRepository.save(response)
        }catch(ex: Exception){
            throw ResponseStatusException(
                HttpStatus.NOT_FOUND, ex.message, ex)
        }
    }
    fun delete (id:Long): Boolean{
        hospedajeRepository.deleteById(id)
        return true
    }
}