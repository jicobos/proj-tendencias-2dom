package com.josecobos.hotelMascotas.service

import com.josecobos.hotelMascotas.model.clienteTabla
import com.josecobos.hotelMascotas.model.mascotaTabla
import com.josecobos.hotelMascotas.repository.clienteRepository
import com.josecobos.hotelMascotas.repository.mascotaRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service

class mascotaService {
    @Autowired
    lateinit var mascotaRepository: mascotaRepository


    fun list(): List<mascotaTabla> {

        return mascotaRepository.findAll()
    }
    fun save(mascotaTabla: mascotaTabla):mascotaTabla{
        return mascotaRepository.save(mascotaTabla)
    }

    fun update(mascotaTabla: mascotaTabla):mascotaTabla{
        return mascotaRepository.save(mascotaTabla)
    }

    fun delete (id:Long): Boolean{
        mascotaRepository.deleteById(id)
        return true
    }
}