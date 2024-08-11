package com.projeto1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto1.entity.Cliente;
import com.projeto1.repository.ClienteRepository;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> getAllClientes() {
        return clienteRepository.findAll();
    }

    public Optional<Cliente> getClienteById(Long id) {
        return clienteRepository.findById(id);
    }

    public Cliente createCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public Optional<Cliente> updateCliente(Long id, Cliente clienteDetails) {
        return clienteRepository.findById(id)
            .map(cliente -> {
                cliente.setNome(clienteDetails.getNome());
                cliente.setEmail(clienteDetails.getEmail());
                cliente.setTelefone(clienteDetails.getTelefone());
                cliente.setIdade(clienteDetails.getIdade());
                cliente.setEndereço(clienteDetails.getEndereço());
                return clienteRepository.save(cliente);
            });
    }

    public void deleteCliente(Long id) {
        clienteRepository.deleteById(id);
    }
    
    public List<Cliente> findClientesByIdade(int start, int end) {
        return clienteRepository.findByIdadeBetween(start, end);
    }    
}