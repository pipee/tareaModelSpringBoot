package com.escalab.service.impl;

import com.escalab.model.Producto;
import com.escalab.repo.IProductoRepo;
import com.escalab.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoServiceImpl implements IProductoService {

    @Autowired
    private IProductoRepo repo;

    @Override
    public Producto registrar(Producto obj) {
        return repo.save(obj);
    }

    @Override
    public Producto modificar(Producto obj) {
        return repo.save(obj);
    }

    @Override
    public List<Producto> listar() {
        return repo.findAll();
    }

    @Override
    public Producto leerPorId(Long id) {
        Optional<Producto> op = repo.findById(id);
        return op.isPresent()? op.get() : new Producto();
    }

    @Override
    public boolean eliminar(Long id) {
        repo.deleteById(id);
        return true;
    }
}
