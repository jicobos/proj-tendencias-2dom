package com.josecobos.hotelMascotas.repository

import com.josecobos.hotelMascotas.model.hospedajeTabla
import org.springframework.data.jpa.repository.JpaRepository

interface hospedajeRepository:JpaRepository<hospedajeTabla,Long> {

}