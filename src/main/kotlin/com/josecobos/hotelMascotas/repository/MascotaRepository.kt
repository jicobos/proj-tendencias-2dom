package com.josecobos.hotelMascotas.repository

import com.josecobos.hotelMascotas.model.MascotaTabla
import org.springframework.data.jpa.repository.JpaRepository

interface MascotaRepository:JpaRepository<MascotaTabla,Long> {
    fun findById(id: Long?): MascotaTabla?
}