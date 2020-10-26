package com.escalab.service.impl;

import com.escalab.model.Supervisor;
import com.escalab.model.Vendedor;
import com.escalab.repo.IVendedorRepo;
import com.escalab.service.IVendedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VendedorServiceImp implements IVendedorService {

    @Autowired
    private IVendedorRepo repo;

    @Override
    public Vendedor registrar(Vendedor obj) {
        return repo.save(obj);
    }

    @Override
    public Vendedor modificar(Vendedor obj) {
        return repo.save(obj);
    }

    @Override
    public List<Vendedor> listar() {
        return repo.findAll();
    }

    @Override
    public Vendedor leerPorId(Long id) {
        Optional<Vendedor> op = repo.findById(id);
        return op.isPresent()? op.get() : new Vendedor();
    }

    @Override
    public boolean eliminar(Long id) {
        repo.deleteById(id);
        return true;
    }
}
