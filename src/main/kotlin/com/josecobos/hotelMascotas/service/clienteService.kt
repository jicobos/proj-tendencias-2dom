package com.josecobos.hotelMascotas.service

import com.josecobos.hotelMascotas.model.clienteTabla
import com.josecobos.hotelMascotas.repository.clienteRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service

class clienteService {
    @Autowired
    lateinit var clienteRepository:clienteRepository


    fun list(): List<clienteTabla> {

        return clienteRepository.findAll()
    }
    fun save(clienteTabla: clienteTabla):clienteTabla{
        return clienteRepository.save(clienteTabla)
    }

    fun update(clienteTabla: clienteTabla):clienteTabla{
        return clienteRepository.save(clienteTabla)
    }

    fun delete (id:Long): Boolean{
        clienteRepository.deleteById(id)
        return true
    }
}