package com.josecobos.hotelMascotas.repository

import com.josecobos.hotelMascotas.model.servicioTabla
import org.springframework.data.jpa.repository.JpaRepository

interface servicioRepository:JpaRepository<servicioTabla,Long> {

}