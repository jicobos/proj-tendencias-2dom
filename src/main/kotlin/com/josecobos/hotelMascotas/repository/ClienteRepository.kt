package com.josecobos.hotelMascotas.repository

import com.josecobos.hotelMascotas.model.ClienteTabla
import org.springframework.data.jpa.repository.JpaRepository

interface ClienteRepository:JpaRepository<ClienteTabla,Long> {
    fun findById(id: Long?): ClienteTabla?

}