package org.trabalhouninter.services;

import org.springframework.stereotype.Service;
import org.trabalhouninter.models.Cliente;
import org.trabalhouninter.repository.ClienteRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {
    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public Cliente salvar(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public Optional<Cliente> buscarPorId(Long id) {
        return clienteRepository.findById(id);
    }

    public List<Cliente> listarTodos() {
        return clienteRepository.findAll();
    }

    public void deletar(Long id) {
        clienteRepository.deleteById(id);
    }

    public Cliente atualizar(Long id, Cliente cliente) {
        return clienteRepository.findById(id)
                .map(clienteExistente -> {
                    clienteExistente.setNome(cliente.getNome());
                    clienteExistente.setClienteDesde(cliente.getClienteDesde());
                    return clienteRepository.save(clienteExistente);
                })
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
    }
}
