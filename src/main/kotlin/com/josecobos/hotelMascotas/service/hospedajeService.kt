package com.josecobos.hotelMascotas.service

import com.josecobos.hotelMascotas.model.clienteTabla
import com.josecobos.hotelMascotas.model.hospedajeTabla
import com.josecobos.hotelMascotas.repository.clienteRepository
import com.josecobos.hotelMascotas.repository.hospedajeRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service

class hospedajeService {
    @Autowired
    lateinit var hospedajeRepository: hospedajeRepository


    fun list(): List<hospedajeTabla> {

        return hospedajeRepository.findAll()
    }
    fun save(hospedajeTabla: hospedajeTabla):hospedajeTabla{
        return hospedajeRepository.save(hospedajeTabla)
    }

    fun update(hospedajeTabla: hospedajeTabla):hospedajeTabla{
        return hospedajeRepository.save(hospedajeTabla)
    }

    fun delete (id:Long): Boolean{
        hospedajeRepository.deleteById(id)
        return true
    }
}