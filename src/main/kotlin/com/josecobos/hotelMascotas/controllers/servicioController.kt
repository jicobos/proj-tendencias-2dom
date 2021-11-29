package com.josecobos.hotelMascotas.controllers

import com.josecobos.hotelMascotas.model.clienteTabla
import com.josecobos.hotelMascotas.model.servicioTabla
import com.josecobos.hotelMascotas.service.clienteService
import com.josecobos.hotelMascotas.service.servicioService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/servicio")
@CrossOrigin(methods = [RequestMethod.GET, RequestMethod.POST, RequestMethod.PATCH, RequestMethod.PUT])

class servicioController {
    @Autowired
    lateinit var servicioService: servicioService

    @GetMapping
    fun list(): List<servicioTabla>{
        return servicioService.list()
    }
    @PostMapping
    fun save(@RequestBody servicioTabla: servicioTabla):servicioTabla{
        return servicioService.save(servicioTabla)
    }

    @PutMapping
    fun update (@RequestBody servicioTabla: servicioTabla):servicioTabla{
        return servicioService.update(servicioTabla)
    }

    @DeleteMapping("/delete/{id}")
    fun delete (@PathVariable("id") id: Long):Boolean{
        return servicioService.delete(id)
    }



}
