package com.escalab.service.impl;

import com.escalab.model.Cliente;
import com.escalab.repo.IClienteRepo;
import com.escalab.service.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements IClienteService {

    @Autowired
    private IClienteRepo repo;

    @Override
    public Cliente registrar(Cliente obj) {
        return repo.save(obj);
    }

    @Override
    public Cliente modificar(Cliente obj) {
        return repo.save(obj);
    }

    @Override
    public List<Cliente> listar() {
        return repo.findAll();
    }

    @Override
    public Cliente leerPorId(Long id) {
        Optional<Cliente> op = repo.findById(id);
        return op.isPresent() ? op.get(): new Cliente();
    }

    @Override
    public boolean eliminar(Long id) {
        repo.deleteById(id);
        return true;
    }
}
