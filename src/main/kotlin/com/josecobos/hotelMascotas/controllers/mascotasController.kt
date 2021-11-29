package com.josecobos.hotelMascotas.controllers

import com.josecobos.hotelMascotas.model.mascotaTabla
import com.josecobos.hotelMascotas.service.mascotaService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/mascotas")
@CrossOrigin(methods = [RequestMethod.GET, RequestMethod.POST, RequestMethod.PATCH, RequestMethod.PUT])

class mascotasController {
    @Autowired
    lateinit var mascotaService: mascotaService

    @GetMapping
    fun list(): List<mascotaTabla>{
        return mascotaService.list()
    }
    @PostMapping
    fun save(@RequestBody mascotaTabla: mascotaTabla):mascotaTabla{
        return mascotaService.save(mascotaTabla)
    }

    @PutMapping
    fun update (@RequestBody mascotaTabla: mascotaTabla):mascotaTabla{
        return mascotaService.update(mascotaTabla)
    }

    @DeleteMapping("/delete/{id}")
    fun delete (@PathVariable("id") id: Long):Boolean{
        return mascotaService.delete(id)
    }



}
