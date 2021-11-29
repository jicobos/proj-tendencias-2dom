package com.josecobos.hotelMascotas.controllers

import com.josecobos.hotelMascotas.model.clienteTabla
import com.josecobos.hotelMascotas.service.clienteService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/clientes")
@CrossOrigin(methods = [RequestMethod.GET, RequestMethod.POST, RequestMethod.PATCH, RequestMethod.PUT])

class clientesController {
    @Autowired
    lateinit var clienteService: clienteService

    @GetMapping
    fun list(): List<clienteTabla>{
        return clienteService.list()
    }
    @PostMapping
    fun save(@RequestBody clienteTabla: clienteTabla):clienteTabla{
        return clienteService.save(clienteTabla)
    }

    @PutMapping
    fun update (@RequestBody clienteTabla: clienteTabla):clienteTabla{
        return clienteService.update(clienteTabla)
    }

    @DeleteMapping("/delete/{id}")
    fun delete (@PathVariable("id") id: Long):Boolean{
        return clienteService.delete(id)
    }



}
