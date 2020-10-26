package com.escalab.controller;

import com.escalab.exception.ModelNotFoundException;
import com.escalab.model.Venta;
import com.escalab.service.IVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping
public class VentaController {
    
    @Autowired
    public IVentaService service;

    @GetMapping
    public ResponseEntity<List<Venta>> listar(){
        List<Venta> listar = service.listar();
        return new ResponseEntity<List<Venta>>(listar, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Venta> listarPorId(
            @PathVariable("id") Long id
    ){
        Venta obj = service.leerPorId(id);
        if (obj.getIdVenta() == null){
            throw new ModelNotFoundException("ID NO ENCONTRADO " + id);
        }
        return new ResponseEntity<Venta>(obj, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Object> registrar(
            @Valid @RequestBody Venta venta
    ){
        Venta obj = service.registrar(venta);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(venta.getIdVenta()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping
    public ResponseEntity<Venta> modificar(
            @Valid @RequestBody Venta venta
    ){
        Venta obj = service.modificar(venta);
        return new ResponseEntity<Venta>(obj, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> eliminar(
            @PathVariable("id") Long id
    ){
        Venta obj = service.leerPorId(id);
        if (obj.getIdVenta() == null){
            throw new ModelNotFoundException("ID NO ENCONTRADO " + id);
        }
        service.eliminar(id);
        return new ResponseEntity<Object>(HttpStatus.OK);
    }
}
