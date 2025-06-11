/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.fastfood.fastfurious.service;

mport java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sesideva
 */

    public class PedidoService {
    private List<Pedido> pedidos;
    public PedidoService() {
    this.pedidos = new ArrayList<>();
    }
    
    public void adicionarPedido(Pedido pedido) {
    pedidos.add(pedido);
    System.out.println("Pedido adicionado: " + pedido);
    }
    
    public void removerPedido(int id) {
    pedidos.removeIf(pedido -> pedido.getId() == id);
    System.out.println("Pedido removido com ID: " + id);
    }
    
    public Pedido buscarPedido(int id) {
        for (Pedido pedido : pedidos) {
        if (pedido.getId() == id) {
        return pedido;
    }
    }
    
    return null; // Retorna null se o pedido não for encontrado
    }
    
    public List<Pedido> listarPedidos() {
        return new ArrayList<>(pedidos);
    }
    
}
