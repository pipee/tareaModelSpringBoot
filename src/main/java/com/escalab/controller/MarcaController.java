package com.escalab.controller;

import com.escalab.exception.ModelNotFoundException;
import com.escalab.model.Marca;
import com.escalab.service.IMarcaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/marca")
public class MarcaController {

    @Autowired
    public IMarcaService service;

    @GetMapping
    public ResponseEntity<List<Marca>> listar(){
        List<Marca> obj = service.listar();
        return new ResponseEntity<List<Marca>>(obj, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Marca> registrar(
            @Valid @RequestBody Marca marca
    ){
        Marca obj = service.registrar(marca);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdMarca()).toUri();
        return ResponseEntity.created(location).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Marca> listarPorId(
            @PathVariable("id") Long id
    ){
        Marca obj = service.leerPorId(id);
        if (obj.getIdMarca() == null){
            throw new ModelNotFoundException("ID NO ENCONTRADO " + id);
        }
        return new ResponseEntity<Marca>(obj, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Marca> modificar(
            @Valid @RequestBody Marca marca
    ){
        Marca obj = service.modificar(marca);
        return new ResponseEntity<Marca>(obj, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> eliminar(@PathVariable("id") Long id){
        Marca obj = service.leerPorId(id);
        if (obj.getIdMarca() == null){
            throw new ModelNotFoundException("ID NO ENCONTRADO " + id);
        }
        service.eliminar(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
