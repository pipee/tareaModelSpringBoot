package com.escalab.service.impl;

import com.escalab.model.CompraProducto;
import com.escalab.repo.ICompraProductoRepo;
import com.escalab.service.ICompraProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompraProductoServiceImpl implements ICompraProductoService {

    @Autowired
    private ICompraProductoRepo repo;


    @Override
    public List<CompraProducto> listarProductosPorCompra(Long idCompra) {
        return repo.listarProductosPorCompra(idCompra);
    }

    @Override
    public Long registrar(Long idVenta, Long idProducto) {
        return repo.registrar(idVenta, idProducto);
    }
}
