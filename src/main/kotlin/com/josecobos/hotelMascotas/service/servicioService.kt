package com.josecobos.hotelMascotas.service

import com.josecobos.hotelMascotas.model.clienteTabla
import com.josecobos.hotelMascotas.model.servicioTabla
import com.josecobos.hotelMascotas.repository.clienteRepository
import com.josecobos.hotelMascotas.repository.servicioRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service

class servicioService {
    @Autowired
    lateinit var servicioRepository: servicioRepository


    fun list(): List<servicioTabla> {

        return servicioRepository.findAll()
    }
    fun save(servicioTabla: servicioTabla):servicioTabla{
        return servicioRepository.save(servicioTabla)
    }

    fun update(servicioTabla: servicioTabla):servicioTabla{
        return servicioRepository.save(servicioTabla)
    }

    fun delete (id:Long): Boolean{
        servicioRepository.deleteById(id)
        return true
    }
}