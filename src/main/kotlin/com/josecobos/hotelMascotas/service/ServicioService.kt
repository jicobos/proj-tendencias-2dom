package com.josecobos.hotelMascotas.service

import com.josecobos.hotelMascotas.model.ServicioTabla
import com.josecobos.hotelMascotas.repository.HospedajeRepository
import com.josecobos.hotelMascotas.repository.ServicioRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service

class ServicioService {
    @Autowired
    lateinit var servicioRepository: ServicioRepository
    @Autowired
    lateinit var hospedajeRepository: HospedajeRepository


    fun list(): List<ServicioTabla> {

        return servicioRepository.findAll()
    }
    fun save(servicioTabla: ServicioTabla):ServicioTabla{
        try{
            if (servicioTabla.tiposervicio?.equals("") == true){
                throw Exception("Tipo de servicio no puede estar vacio")
            }
            if (servicioTabla.hospedajeId?.equals("") == true){
                throw Exception("Hospedaje no puede estar vacio")
            }
            hospedajeRepository.findById(servicioTabla.hospedajeId
                ?: throw Exception("No existe registro de hospedaje"))
            return servicioRepository.save(servicioTabla)
        }catch(ex: Exception){
            throw ResponseStatusException(
                HttpStatus.NOT_FOUND, ex.message, ex)
        }

    }

    fun update(servicioTabla: ServicioTabla):ServicioTabla{
        try{
            if (servicioTabla.tiposervicio?.equals("") == true){
                throw Exception("Tipo de servicio no puede estar vacio")
            }
            if (servicioTabla.hospedajeId?.equals("") == true){
                throw Exception("Hospedaje no puede estar vacio")
            }
            hospedajeRepository.findById(servicioTabla.hospedajeId
                ?: throw Exception("No existe registro de hospedaje"))
            val response = servicioRepository.findById(servicioTabla.id)
                ?: throw Exception("El id ${servicioTabla.id} en servicio no existe")
            response.apply{
               tiposervicio=servicioTabla.tiposervicio
                hospedajeId=servicioTabla.hospedajeId
            }
            return servicioRepository.save(response)
        }catch(ex: Exception){
            throw ResponseStatusException(
                HttpStatus.NOT_FOUND, ex.message, ex)
        }

    }
    fun updateDescription(servicioTabla: ServicioTabla):ServicioTabla{
        try{
            if (servicioTabla.tiposervicio?.equals("") == true){
                throw Exception("Tipo de servicio no puede estar vacio")
            }
            if (servicioTabla.hospedajeId?.equals("") == true){
                throw Exception("Hospedaje no puede estar vacio")
            }
            hospedajeRepository.findById(servicioTabla.hospedajeId
                ?: throw Exception("No existe registro de hospedaje"))
            val response = servicioRepository.findById(servicioTabla.id)
                ?: throw Exception("El id ${servicioTabla.id} en servicio no existe")
            response.apply{
                tiposervicio=servicioTabla.tiposervicio
                hospedajeId=servicioTabla.hospedajeId
            }
            return servicioRepository.save(response)
        }catch(ex: Exception){
            throw ResponseStatusException(
                HttpStatus.NOT_FOUND, ex.message, ex)
        }

    }

    fun delete (id:Long): Boolean{
        servicioRepository.deleteById(id)
        return true
    }
}