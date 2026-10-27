package org.trabalhouninter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.trabalhouninter.models.Cliente;
import org.trabalhouninter.models.Produto;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
