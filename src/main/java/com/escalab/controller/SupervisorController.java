package com.escalab.controller;

import com.escalab.exception.ModelNotFoundException;
import com.escalab.model.Supervisor;
import com.escalab.service.ISupervisorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/supervisor")
public class SupervisorController {

    @Autowired
    private ISupervisorService service;

    @GetMapping
    public ResponseEntity<List<Supervisor>> listar(){
        List<Supervisor> listar = service.listar();
        return new ResponseEntity<List<Supervisor>>(listar, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Supervisor> listarPorId(
            @PathVariable("id") Long id
    ){
        Supervisor obj = service.leerPorId(id);
        if(obj.getIdSupervisor() == null){
            throw new ModelNotFoundException("ID NO ENCONTRADO " + id);
        }
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Object> registrar(
            @Valid @RequestBody Supervisor supervisor
    ){
        Supervisor obj = service.registrar(supervisor);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(supervisor.getIdSupervisor()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping
    public ResponseEntity<Supervisor> modificar(
            @Valid @RequestBody Supervisor supervisor
    ){
        Supervisor obj = service.modificar(supervisor);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> eliminar(
            @PathVariable("id") Long id
    ){
        Supervisor obj = service.leerPorId(id);
        if (obj.getIdSupervisor() == null){
            throw new ModelNotFoundException("ID NO ENCONTRADO " + id);
        }
        service.eliminar(id);
        return new ResponseEntity<Object>(HttpStatus.OK);
    }
}
