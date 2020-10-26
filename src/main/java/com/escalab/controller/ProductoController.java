package com.escalab.controller;

import com.escalab.exception.ModelNotFoundException;
import com.escalab.model.Producto;
import com.escalab.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("producto")
public class ProductoController {

    @Autowired
    private IProductoService service;

    @GetMapping
    public ResponseEntity<List<Producto>> listar(){
        List<Producto> lista = service.listar();
        return new ResponseEntity<List<Producto>>(lista, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Producto> listarPorId(
            @PathVariable("id") Long id
    ){
        Producto obj = service.leerPorId(id);
        if (obj.getIdProducto() == null){
            throw new ModelNotFoundException("ID NO ENCONTRADO " + id);
        }
        return new ResponseEntity<Producto>(obj, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Object> registrar(
            @Valid @RequestBody Producto producto
    ){
        Producto obj = service.registrar(producto);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(producto.getIdProducto()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping
    public ResponseEntity<Producto> modificar(
            @Valid @RequestBody Producto producto
    ){
        Producto obj = service.modificar(producto);
        return new ResponseEntity<Producto>(obj, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> eliminar(
            @PathVariable("id") Long id
    ){
        Producto obj = service.leerPorId(id);
        if(obj.getIdProducto() == null){
            throw new ModelNotFoundException("ID NO ENCONTRADO " + id);
        }
        service.eliminar(id);
        return new ResponseEntity<Object>(HttpStatus.OK);
    }
}
