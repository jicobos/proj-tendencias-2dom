package com.josecobos.hotelMascotas.repository

import com.josecobos.hotelMascotas.model.clienteTabla
import org.springframework.data.jpa.repository.JpaRepository

interface clienteRepository:JpaRepository<clienteTabla,Long> {

}