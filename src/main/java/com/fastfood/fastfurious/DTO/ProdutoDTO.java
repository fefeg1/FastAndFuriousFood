/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.fastfood.fastfurious.produtoDTO;

/**
 *
 * @author sesideva
 */
  public class ProdutoDTO {
    
    private Long id;
    private String nome;
    private String categoria;
    private Double preco;
    public ProdutoDTO() {
    }

    public ProdutoDTO(Long id, String nome, String categoria, Double preco) {
    this.id = id;
    this.nome = nome;
    this.categoria = categoria;
    this.preco = preco;
    }

    public Long getId() {
    return id;
    }

    public void setId(Long id) {
    this.id = id;
    }

    public String getNome() {
    return nome;
    }

    public void setNome(String nome) {
    this.nome = nome;
    }

    public String getCategoria() {
    return categoria;
    }

    public void setCategoria(String categoria) {
    this.categoria = categoria;
    }

    public Double getPreco() {
    return preco;
    }

    public void setPreco(Double preco) {
    this.preco = preco;
    }

    }

    }
