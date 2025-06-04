/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.fastfood.fastfurious.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 *
 * @author sesideva
 */

    @RestController
    @RequestMapping("/api/pedidos")
    public class PedidoController {
        
    @Autowired
    private PedidoService pedidoService;
    
    @PostMapping
    public ResponseEntity<Pedido> criarPedido(@RequestBody Pedido pedido) {
    pedidoService.adicionarPedido(pedido);
        return ResponseEntity.ok(pedido);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Pedido> obterPedido(@PathVariable int id) {
    Pedido pedido = pedidoService.buscarPedido(id);
    if (pedido != null) {
        return ResponseEntity.ok(pedido);
    } else {
        return ResponseEntity.notFound().build();
    }
    }
    
    @GetMapping
    public ResponseEntity<List<Pedido>> listarPedidos() {
    List<Pedido> pedidos = pedidoService.listarPedidos();
        return ResponseEntity.ok(pedidos);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerPedido(@PathVariable int id) {
    pedidoService.removerPedido(id);
        return ResponseEntity.noContent().build();
    }
    
}
