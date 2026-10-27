package org.trabalhouninter.services;

import org.springframework.stereotype.Service;
import org.trabalhouninter.models.Pedido;
import org.trabalhouninter.repository.PedidoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {
    private final PedidoRepository pedidoRepository;

    public PedidoService(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    public Pedido salvar(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    public Optional<Pedido> buscarPorId(Long id) {
        return pedidoRepository.findById(id);
    }

    public List<Pedido> listarTodos() {
        return pedidoRepository.findAll();
    }

    public void deletar(Long id) {
        pedidoRepository.deleteById(id);
    }

    public Pedido atualizar(Long id, Pedido pedido) {
        return pedidoRepository.findById(id)
                .map(pedidoExistente -> {
                    pedidoExistente.setCliente(pedido.getCliente());
                    pedidoExistente.setProduto(pedido.getProduto());
                    pedidoExistente.setQuantidade(pedido.getQuantidade());
                    return pedidoRepository.save(pedidoExistente);
                })
                .orElseThrow(() -> new RuntimeException("Pedido não encontrado"));
    }
}
