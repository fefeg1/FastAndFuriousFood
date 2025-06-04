/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.fastfood.fastfurious.produtoDTO;

/**
 *
 * @author sesideva
 */
    public class PedidoDTO {
    private Long id;
    private LocalDateTime dataHora;
    private String status;
    private List<ItemPedidoDTO> itens = new ArrayList<>();
    public PedidoDTO() {
    }

    public PedidoDTO(Long id, LocalDateTime dataHora, String status, List<ItemPedidoDTO> itens) {
        this.id = id;
        this.dataHora = dataHora;
        this.status = status;
        this.itens = itens;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<ItemPedidoDTO> getItens() {
        return itens;
    }

    public void setItens(List<ItemPedidoDTO> itens) {
        this.itens = itens;
    }


    }