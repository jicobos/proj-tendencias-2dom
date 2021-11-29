package com.josecobos.hotelMascotas.controllers

import com.josecobos.hotelMascotas.model.hospedajeTabla
import com.josecobos.hotelMascotas.model.mascotaTabla
import com.josecobos.hotelMascotas.service.hospedajeService
import com.josecobos.hotelMascotas.service.mascotaService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/hospedaje")
@CrossOrigin(methods = [RequestMethod.GET, RequestMethod.POST, RequestMethod.PATCH, RequestMethod.PUT])

class hospedajeController {
    @Autowired
    lateinit var hospedajeService: hospedajeService

    @GetMapping
    fun list(): List<hospedajeTabla>{
        return hospedajeService.list()
    }
    @PostMapping
    fun save(@RequestBody hospedajeTabla: hospedajeTabla):hospedajeTabla{
        return hospedajeService.save(hospedajeTabla)
    }

    @PutMapping
    fun update (@RequestBody hospedajeTabla: hospedajeTabla):hospedajeTabla{
        return hospedajeService.update(hospedajeTabla)
    }

    @DeleteMapping("/delete/{id}")
    fun delete (@PathVariable("id") id: Long):Boolean{
        return hospedajeService.delete(id)
    }



}
