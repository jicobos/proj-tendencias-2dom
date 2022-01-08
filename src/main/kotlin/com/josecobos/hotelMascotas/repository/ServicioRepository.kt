package com.josecobos.hotelMascotas.repository

import com.josecobos.hotelMascotas.model.MascotaTabla
import com.josecobos.hotelMascotas.model.ServicioTabla
import org.springframework.data.jpa.repository.JpaRepository

interface ServicioRepository:JpaRepository<ServicioTabla,Long> {
    fun findById(id: Long?): ServicioTabla?
}