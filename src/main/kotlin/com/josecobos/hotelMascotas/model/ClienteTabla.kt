package com.josecobos.hotelMascotas.model

import javax.persistence.*

@Entity
@Table(name = "clientes")
class ClienteTabla {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null
    var nombre: String? = null
    var apellido: String? = null
    var cedula: String? = null
    var direccion: String? = null
    var correo: String? = null
    var telefono: String? = null

}