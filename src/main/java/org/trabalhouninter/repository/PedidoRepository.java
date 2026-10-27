package org.trabalhouninter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.trabalhouninter.models.Cliente;
import org.trabalhouninter.models.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
