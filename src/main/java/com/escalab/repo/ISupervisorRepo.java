package com.escalab.repo;

import com.escalab.model.Supervisor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISupervisorRepo extends JpaRepository<Supervisor, Long> {
}
