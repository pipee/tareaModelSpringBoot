package com.escalab.service.impl;

import com.escalab.model.Venta;
import com.escalab.repo.IVentaRepo;
import com.escalab.service.IVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VentaServiceImpl implements IVentaService {

    @Autowired
    private IVentaRepo repo;
    @Override
    public Venta registrar(Venta obj) {
        return repo.save(obj);
    }

    @Override
    public Venta modificar(Venta obj) {
        return repo.save(obj);
    }

    @Override
    public List<Venta> listar() {
        return repo.findAll();
    }

    @Override
    public Venta leerPorId(Long id) {
        Optional<Venta> op = repo.findById(id);
        return op.isPresent()? op.get() : new Venta();
    }

    @Override
    public boolean eliminar(Long id) {
        repo.deleteById(id);
        return true;
    }
}
