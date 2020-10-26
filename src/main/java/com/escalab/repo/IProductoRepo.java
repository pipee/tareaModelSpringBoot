package com.escalab.repo;

import com.escalab.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductoRepo extends JpaRepository<Producto, Long> {
}
