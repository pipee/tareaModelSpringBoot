package com.escalab.controller;

import com.escalab.model.CompraProducto;
import com.escalab.service.ICompraProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/compraProducto")
public class CompraProductoController {

    @Autowired
    public ICompraProductoService service;

    @GetMapping("/{id}")
    public ResponseEntity<List<CompraProducto>> listarPorIdCompra(
            @PathVariable("id") Long id
    ){
        List<CompraProducto> lista = service.listarProductosPorCompra(id);
        return new ResponseEntity<List<CompraProducto>>(lista, HttpStatus.OK);
    }

    @PostMapping("/{idVenta}/{idProducto}")
    public ResponseEntity<Long> registra(
            @PathVariable("idVenta") Long idVenta,
            @PathVariable("idProducto") Long idProducto
    ){
        Long id = service.registrar(idVenta,idProducto);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/id").buildAndExpand(id).toUri();
        return ResponseEntity.created(location).build();
    }
}
