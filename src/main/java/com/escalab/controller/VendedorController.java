package com.escalab.controller;

import com.escalab.exception.ModelNotFoundException;
import com.escalab.model.Vendedor;
import com.escalab.service.IVendedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/vendedor")
public class VendedorController {

    @Autowired
    public IVendedorService service;

    @GetMapping
    public ResponseEntity<List<Vendedor>> listar(){
        List<Vendedor> listar = service.listar();
        return new ResponseEntity<List<Vendedor>>(listar, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vendedor> listarPorId(
            @PathVariable("id") Long id
    ){
        Vendedor obj = service.leerPorId(id);
        if (obj.getIdVendedor() == null){
            throw new ModelNotFoundException("ID NO ENCONTRADO " + id);
        }
        return new ResponseEntity<Vendedor>(obj, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Object> registrar(
            @Valid @RequestBody Vendedor vendedor
    ){
        Vendedor obj = service.registrar(vendedor);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(vendedor.getIdVendedor()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping
    public ResponseEntity<Vendedor> modificar(
            @Valid @RequestBody Vendedor vendedor
    ){
        Vendedor obj = service.modificar(vendedor);
        return new ResponseEntity<Vendedor>(obj, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> eliminar(
            @PathVariable("id") Long id
    ){
        Vendedor obj = service.leerPorId(id);
        if (obj.getIdVendedor() == null){
            throw new ModelNotFoundException("ID NO ENCONTRADO " + id);
        }
        service.eliminar(id);
        return new ResponseEntity<Object>(HttpStatus.OK);
    }
}
