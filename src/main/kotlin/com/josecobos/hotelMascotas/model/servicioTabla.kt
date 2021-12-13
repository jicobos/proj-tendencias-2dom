package com.josecobos.hotelMascotas.model

import javax.persistence.*

@Entity
@Table(name = "servicio")
class servicioTabla {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null
    var tiposervicio: String? = null
    @Column(name="idHospedaje")
    var hospedajeId : Long? = null

}