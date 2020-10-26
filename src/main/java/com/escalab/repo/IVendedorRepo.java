package com.escalab.repo;

import com.escalab.model.Vendedor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IVendedorRepo extends JpaRepository<Vendedor, Long> {
}
