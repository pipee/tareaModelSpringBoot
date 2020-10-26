package com.escalab.service.impl;

import com.escalab.model.Supervisor;
import com.escalab.repo.ISupervisorRepo;
import com.escalab.service.ISupervisorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SupervisorServiceImpl implements ISupervisorService {

    @Autowired
    private ISupervisorRepo repo;

    @Override
    public Supervisor registrar(Supervisor obj) {
        return repo.save(obj);
    }

    @Override
    public Supervisor modificar(Supervisor obj) {
        return repo.save(obj);
    }

    @Override
    public List<Supervisor> listar() {
        return repo.findAll();
    }

    @Override
    public Supervisor leerPorId(Long id) {
        Optional<Supervisor> op = repo.findById(id);
        return op.isPresent()? op.get(): new Supervisor();
    }

    @Override
    public boolean eliminar(Long id) {
        repo.deleteById(id);
        return true;
    }
}
