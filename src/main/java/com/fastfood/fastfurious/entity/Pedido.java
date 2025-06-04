/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.fastfood.fastfurious.entity;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence;

/**
 *
 * @author sesideva
 */

    @Entity
    @Table(name = "pedidos")
    public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private LocalDateTime dataHora;

    @Enumerated(EnumType.STRING)

    private StatusPedido status;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "pedido_id")

    private List<ItemPedido> itens = new ArrayList<>();
    public Pedido() {
    this.dataHora = LocalDateTime.now();
    this.status = StatusPedido.ABERTO;
    }

    public Pedido(Long id, LocalDateTime dataHora, StatusPedido status, List<ItemPedido> itens) {
    [this.id](http://this.id/) = id;
    this.dataHora = dataHora;
    this.status = status;
    this.itens = itens;
    }

    // Getters and Setters
    public Long getId() {
    return id;
    }

    public void setId(Long id) {
    [this.id](http://this.id/) = id;
    }

    public LocalDateTime getDataHora() {
    return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
    this.dataHora = dataHora;
    }

    public StatusPedido getStatus() {
    return status;
    }

    public void setStatus(StatusPedido status) {
    this.status = status;
    }

    public List<ItemPedido> getItens() {
    return itens;
    }

    public void setItens(List<ItemPedido> itens) {
    this.itens = itens;
    }

    public void addItem(ItemPedido item) {
    this.itens.add(item);
    }

    public enum StatusPedido {
    ABERTO, CANCELADO, PRONTO, ENTREGUE
    }
    }