package com.escalab.service;

import com.escalab.model.CompraProducto;

import java.util.List;

public interface ICompraProductoService{

    List<CompraProducto> listarProductosPorCompra(Long idCompra);

    Long registrar(Long idVenta, Long idProducto);
}
