/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.fastfood.fastfurious.service;

/**
 *
 * @author sesideva
 */
package com.fastfood.fastfurious.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fastfood.fastfurious.DTO.ClienteDTO;
import com.fastfood.fastfurious.entity.Cliente;
import com.fastfood.fastfurious.repository.ClienteRepository;

import jakarta.persistence.EntityNotFoundException;

/**

- Service class for managing Cliente entities
- Author: sesideva
*/
    @Service
    public class ClienteService {
    private final ClienteRepository clienteRepository;

        @Autowired
        public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
        }

        public List<ClienteDTO> listarTodos() {
        List<Cliente> clientes = clienteRepository.findAll();
        return clientes.stream()
        .map(this::converterParaDTO)
        .collect(Collectors.toList());
        }

        public ClienteDTO adicionar(ClienteDTO clienteDTO) {
        Cliente cliente = converterParaEntidade(clienteDTO);
        Cliente salvo = clienteRepository.save(cliente);
        return converterParaDTO(salvo);
        }

        public ClienteDTO atualizar(Long id, ClienteDTO clienteDTO) {
        Cliente clienteExistente = clienteRepository.findById(id)
        .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado: " + id));
        clienteExistente.setNome(clienteDTO.getNome());
        clienteExistente.setEmail(clienteDTO.getEmail());
        clienteExistente.setTelefone(clienteDTO.getTelefone());
        clienteExistente.setEndereco(clienteDTO.getEndereco());
        Cliente atualizado = clienteRepository.save(clienteExistente);
        return converterParaDTO(atualizado);
        }

        public void deletar(Long id) {
        clienteRepository.deleteById(id);
        }

        public ClienteDTO buscarPorId(Long id) {
        Cliente cliente = clienteRepository.findById(id)
        .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado: " + id));
        return converterParaDTO(cliente);
        }

        private ClienteDTO converterParaDTO(Cliente cliente) {
        return new ClienteDTO(
        cliente.getId(),
        cliente.getNome(),
        cliente.getEmail(),
        cliente.getTelefone(),
        cliente.getEndereco()
        );
        }

        private Cliente converterParaEntidade(ClienteDTO clienteDTO) {
        Cliente cliente = new Cliente();
        cliente.setId(clienteDTO.getId());
        cliente.setNome(clienteDTO.getNome());
        cliente.setEmail(clienteDTO.getEmail());
        cliente.setTelefone(clienteDTO.getTelefone());
        cliente.setEndereco(clienteDTO.getEndereco());
        return cliente;
        }
        }