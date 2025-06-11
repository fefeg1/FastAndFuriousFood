/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.fastfood.fastfurious.domain.model;

/**
 *
 * @author sesideva
 */
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import [jakarta.persistence.Id](http://jakarta.persistence.id/);
import jakarta.persistence.Table;

/**

- Entity representing a Cliente (Customer).
- Author: sesideva
*/
@Entity
@Table(name = "clientes")
public class Cliente {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
    
    private String nome;
    
    private String email;
    
    private String telefone;
    
    private String endereco;
    
    // Constructors
    public Cliente() {
    }
    
    public Cliente(Long id, String nome, String email, String telefone, String endereco) {
    [this.id](http://this.id/) = id;
    this.nome = nome;
    this.email = email;
    this.telefone = telefone;
    this.endereco = endereco;
    }
    
    // Getters and setters
    public Long getId() {
    return id;
    }
    
    public void setId(Long id) {
    [this.id](http://this.id/) = id;
    }
    
    public String getNome() {
    return nome;
    }
    
    public void setNome(String nome) {
    this.nome = nome;
    }
    
    public String getEmail() {
    return email;
    }
    
    public void setEmail(String email) {
    this.email = email;
    }
    
    public String getTelefone() {
    return telefone;
    }
    
    public void setTelefone(String telefone) {
    this.telefone = telefone;
    }
    
    public String getEndereco() {
    return endereco;
    }
    
    public void setEndereco(String endereco) {
    this.endereco = endereco;
    }
    