package com.escalab.repo;

import com.escalab.model.Venta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IVentaRepo extends JpaRepository<Venta, Long> {
}
