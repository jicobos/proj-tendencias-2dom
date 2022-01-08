package com.josecobos.hotelMascotas.model

import java.sql.Date
import javax.persistence.*

@Entity
@Table(name = "hospedaje")
class HospedajeTabla {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null
    var fechaingreso: Date? = null
    var fechasalida: Date? = null
    var numerohabitacion: String? = null
    @Column(name="idMascota")
    var mascotaId : Long? = null
}