/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.fastfood.fastfurious.produtoservice;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fastfurious.api.dto.ProdutoDTO;
import com.fastfurious.api.entity.Produto;
import com.fastfurious.api.repository.ProdutoRepository;
import jakarta.persistence.EntityNotFoundException;

/**
 *
 * @author sesideva
 */


    @Service
    public class ProdutoService {
    private final ProdutoRepository produtoRepository;

    @Autowired
    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public List<ProdutoDTO> listarTodos() {
        List<Produto> produtos = produtoRepository.findAll();
        return produtos.stream()
                .map(this::converterParaDTO)
                .collect(Collectors.toList());
    }

    public ProdutoDTO adicionar(ProdutoDTO produtoDTO) {
        Produto produto = converterParaEntidade(produtoDTO);
        Produto salvo = produtoRepository.save(produto);
        return converterParaDTO(salvo);
         }

    public ProdutoDTO atualizar(Long id, ProdutoDTO produtoDTO) {
        Produto produtoExistente = produtoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Produto não encontrado: " + id));
        produtoExistente.setNome(produtoDTO.getNome());
        produtoExistente.setCategoria(produtoDTO.getCategoria());
        produtoExistente.setPreco(produtoDTO.getPreco());
        Produto atualizado = produtoRepository.save(produtoExistente);
        return converterParaDTO(atualizado);
    }

    public void deletar(Long id) {
        produtoRepository.deleteById(id);
    }

    public List<ProdutoDTO> listarPorCategoria(String categoria) {
        List<Produto> produtos = produtoRepository.findByCategoria(categoria);
        return produtos.stream()
                .map(this::converterParaDTO)
                .collect(Collectors.toList());
    }

    public ProdutoDTO buscarPorId(Long id) {
        Produto produto = produtoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Produto não encontrado: " + id));
        return converterParaDTO(produto);
    }

    private ProdutoDTO converterParaDTO(Produto produto) {
        return new ProdutoDTO(produto.getId(), produto.getNome(), produto.getCategoria(), produto.getPreco());
    }

    private Produto converterParaEntidade(ProdutoDTO produtoDTO) {
        Produto produto = new Produto();
        produto.setId(produtoDTO.getId());
        produto.setNome(produtoDTO.getNome());
        produto.setCategoria(produtoDTO.getCategoria());
        produto.setPreco(produtoDTO.getPreco());
        return produto;
    }
    
}
