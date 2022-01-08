package com.josecobos.hotelMascotas.controllers

import com.josecobos.hotelMascotas.model.ClienteTabla
import com.josecobos.hotelMascotas.service.ClienteService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/clientes")
@CrossOrigin(methods = [RequestMethod.GET, RequestMethod.POST, RequestMethod.PATCH, RequestMethod.PUT])

class clientesController {
    @Autowired
    lateinit var clienteService: ClienteService

    @GetMapping
    fun list(): List<ClienteTabla>{
        return clienteService.list()
    }
    @PostMapping
    fun save(@RequestBody ClienteTabla: ClienteTabla):ClienteTabla{
        return clienteService.save(ClienteTabla)
    }

    @PutMapping
    fun update (@RequestBody ClienteTabla: ClienteTabla):ClienteTabla{
        return clienteService.update(ClienteTabla)
    }

    @PatchMapping
    fun updateDescription (@RequestBody ClienteTabla: ClienteTabla):ClienteTabla{
        return clienteService.updateDescription(ClienteTabla)
    }

    @DeleteMapping("/delete/{id}")
    fun delete (@PathVariable("id") id: Long):Boolean{
        return clienteService.delete(id)
    }



}
