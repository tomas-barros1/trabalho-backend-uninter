package org.trabalhouninter.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Pedido {
    @Id
    private Long id;

    @OneToOne
    @JoinColumn(name = "clienteId")
    private Cliente cliente;

    @OneToOne
    @JoinColumn(name = "produtoId")
    private Produto produto;

    private int quantidade;

    public Pedido(){}

    public Pedido(Long id, Cliente cliente, Produto produto, int quantidade) {
        this.id = id;
        this.cliente = cliente;
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
