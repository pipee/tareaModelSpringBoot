package com.escalab.repo;

import com.escalab.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IClienteRepo extends JpaRepository<Cliente, Long> {

}
