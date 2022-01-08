package com.josecobos.hotelMascotas.controllers

import com.josecobos.hotelMascotas.model.HospedajeTabla
import com.josecobos.hotelMascotas.service.HospedajeService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/hospedaje")
@CrossOrigin(methods = [RequestMethod.GET, RequestMethod.POST, RequestMethod.PATCH, RequestMethod.PUT])

class hospedajeController {
    @Autowired
    lateinit var hospedajeService: HospedajeService

    @GetMapping
    fun list(): List<HospedajeTabla>{
        return hospedajeService.list()
    }
    @PostMapping
    fun save(@RequestBody HospedajeTabla: HospedajeTabla):HospedajeTabla{
        return hospedajeService.save(HospedajeTabla)
    }

    @PutMapping
    fun update (@RequestBody HospedajeTabla: HospedajeTabla):HospedajeTabla{
        return hospedajeService.update(HospedajeTabla)
    }
    @PatchMapping
    fun updateDescription (@RequestBody HospedajeTabla: HospedajeTabla):HospedajeTabla{
        return hospedajeService.updateDescription(HospedajeTabla)
    }

    @DeleteMapping("/delete/{id}")
    fun delete (@PathVariable("id") id: Long):Boolean{
        return hospedajeService.delete(id)
    }



}
