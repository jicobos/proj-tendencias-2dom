package com.josecobos.hotelMascotas.repository

import com.josecobos.hotelMascotas.model.mascotaTabla
import org.springframework.data.jpa.repository.JpaRepository

interface mascotaRepository:JpaRepository<mascotaTabla,Long> {

}