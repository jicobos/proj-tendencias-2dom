package com.josecobos.hotelMascotas.controllers

import com.josecobos.hotelMascotas.model.ClienteTabla
import com.josecobos.hotelMascotas.model.MascotaTabla
import com.josecobos.hotelMascotas.service.MascotaService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/mascotas")
@CrossOrigin(methods = [RequestMethod.GET, RequestMethod.POST, RequestMethod.PATCH, RequestMethod.PUT])

class mascotasController {
    @Autowired
    lateinit var mascotaService: MascotaService

    @GetMapping
    fun list(): List<MascotaTabla>{
        return mascotaService.list()
    }
    @PostMapping
    fun save(@RequestBody MascotaTabla: MascotaTabla):MascotaTabla{
        return mascotaService.save(MascotaTabla)
    }

    @PutMapping
    fun update (@RequestBody MascotaTabla: MascotaTabla):MascotaTabla{
        return mascotaService.update(MascotaTabla)
    }
    @PatchMapping
    fun updateDescription (@RequestBody MascotaTabla: MascotaTabla):MascotaTabla {
        return mascotaService.updateDescription(MascotaTabla)
    }

    @DeleteMapping("/delete/{id}")
    fun delete (@PathVariable("id") id: Long):Boolean{
        return mascotaService.delete(id)
    }



}
