package com.josecobos.hotelMascotas.service

import com.josecobos.hotelMascotas.model.servicioTabla
import com.josecobos.hotelMascotas.repository.hospedajeRepository
import com.josecobos.hotelMascotas.repository.servicioRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service

class servicioService {
    @Autowired
    lateinit var servicioRepository: servicioRepository
    @Autowired
    lateinit var hospedajeRepository: hospedajeRepository


    fun list(): List<servicioTabla> {

        return servicioRepository.findAll()
    }
    fun save(servicioTabla: servicioTabla):servicioTabla{
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

    fun update(servicioTabla: servicioTabla):servicioTabla{
        try{
            if (servicioTabla.tiposervicio?.equals("") == true){
                throw Exception("Tipo de servicio no puede estar vacio")
            }
            if (servicioTabla.hospedajeId?.equals("") == true){
                throw Exception("Hospedaje no puede estar vacio")
            }
            hospedajeRepository.findById(servicioTabla.hospedajeId
                ?: throw Exception("No existe registro de hospedaje"))
            val response = servicioRepository.findById(servicioTabla.id
                ?: throw Exception("El id ${servicioTabla.id} en servicio no existe"))
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