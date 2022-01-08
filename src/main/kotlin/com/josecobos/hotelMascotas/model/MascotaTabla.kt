package com.josecobos.hotelMascotas.model

import javax.persistence.*

@Entity
@Table(name = "mascotas")
class MascotaTabla {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null
    var nombre: String? = null
    var tipo: String? = null
    var raza: String? = null
    var edad: String? = null
    var tipocomida: String? = null
    var enfermedades: String? = null
    @Column(name="idCliente")
    var clienteId : Long? = null

}