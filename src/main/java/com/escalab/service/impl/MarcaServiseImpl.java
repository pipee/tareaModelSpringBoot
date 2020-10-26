package com.escalab.service.impl;

import com.escalab.model.Marca;
import com.escalab.repo.IMarcaRepo;
import com.escalab.service.IMarcaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MarcaServiseImpl implements IMarcaService {

    @Autowired
    private IMarcaRepo repo;

    @Override
    public Marca registrar(Marca obj) {
        return repo.save(obj);
    }

    @Override
    public Marca modificar(Marca obj) {
        return repo.save(obj);
    }

    @Override
    public List<Marca> listar() {
        return repo.findAll();
    }

    @Override
    public Marca leerPorId(Long id) {
        Optional<Marca> op = repo.findById(id);
        return op.isPresent()? op.get(): new Marca();
    }

    @Override
    public boolean eliminar(Long id) {
        repo.deleteById(id);
        return true;
    }
}
