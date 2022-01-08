package com.josecobos.hotelMascotas.controllers

import com.josecobos.hotelMascotas.model.ServicioTabla
import com.josecobos.hotelMascotas.service.ServicioService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/servicio")
@CrossOrigin(methods = [RequestMethod.GET, RequestMethod.POST, RequestMethod.PATCH, RequestMethod.PUT])

class servicioController {
    @Autowired
    lateinit var servicioService: ServicioService

    @GetMapping
    fun list(): List<ServicioTabla>{
        return servicioService.list()
    }
    @PostMapping
    fun save(@RequestBody servicioTabla: ServicioTabla):ServicioTabla{
        return servicioService.save(servicioTabla)
    }

    @PutMapping
    fun update (@RequestBody servicioTabla: ServicioTabla):ServicioTabla{
        return servicioService.update(servicioTabla)
    }
    @PatchMapping
    fun updateDescription (@RequestBody servicioTabla: ServicioTabla):ServicioTabla{
        return servicioService.updateDescription(servicioTabla)
    }

    @DeleteMapping("/delete/{id}")
    fun delete (@PathVariable("id") id: Long):Boolean{
        return servicioService.delete(id)
    }



}
