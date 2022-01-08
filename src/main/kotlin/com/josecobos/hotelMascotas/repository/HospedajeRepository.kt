package com.josecobos.hotelMascotas.repository

import com.josecobos.hotelMascotas.model.MascotaTabla
import com.josecobos.hotelMascotas.model.HospedajeTabla
import org.springframework.data.jpa.repository.JpaRepository

interface HospedajeRepository:JpaRepository<HospedajeTabla,Long> {
    fun findById(id: Long?): HospedajeTabla?
}