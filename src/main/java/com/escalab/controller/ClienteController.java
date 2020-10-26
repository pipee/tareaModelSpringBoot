package com.escalab.controller;

import com.escalab.exception.ModelNotFoundException;
import com.escalab.model.Cliente;
import com.escalab.service.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private IClienteService service;

    @GetMapping
    public ResponseEntity<List<Cliente>> listar(){
         List<Cliente> list = service.listar();
         return new ResponseEntity<List<Cliente>>(list, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Object> registrar(
            @Valid @RequestBody Cliente obj
    ){
        Cliente cliente = service.registrar(obj);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdCliente()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping
    public ResponseEntity<Cliente> modificar(
            @Valid @RequestBody Cliente obj
    ){
        Cliente cliente = service.modificar(obj);
        return  new ResponseEntity<Cliente>(cliente, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> eliminar(
            @PathVariable("id") Long id
    ){
        Cliente obj = service.leerPorId(id);
        if (obj.getIdCliente() == null){
            throw new ModelNotFoundException("ID NO ENCONTRADO "+ id);
        }
        service.eliminar(id);
        return new ResponseEntity<Object>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> listarPorId(
            @PathVariable("id") Long id
    ){
        Cliente obj = service.leerPorId(id);
        if (obj.getIdCliente() == null){
            throw new ModelNotFoundException("ID NO ENCONTRADO "+ id);
        }
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
}
