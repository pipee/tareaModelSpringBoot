package com.escalab.repo;

import com.escalab.model.Marca;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMarcaRepo extends JpaRepository<Marca, Long> {
}
