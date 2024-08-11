package com.projeto1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto1.entity.Funcionario;
import com.projeto1.repository.FuncionarioRepository;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public List<Funcionario> getAllFuncionarios() {
        return funcionarioRepository.findAll();
    }

    public Optional<Funcionario> getFuncionarioById(Long id) {
        return funcionarioRepository.findById(id);
    }

    public Funcionario createFuncionario(Funcionario funcionario) {
        return funcionarioRepository.save(funcionario);
    }

    public Optional<Funcionario> updateFuncionario(Long id, Funcionario funcionarioDetails) {
        return funcionarioRepository.findById(id)
            .map(funcionario -> {
                funcionario.setNome(funcionarioDetails.getNome());
                funcionario.setEmail(funcionarioDetails.getEmail());
                funcionario.setTelefone(funcionarioDetails.getTelefone());
                funcionario.setIdade(funcionarioDetails.getIdade());
                funcionario.setEndereço(funcionarioDetails.getEndereço());
                funcionario.setFunção(funcionarioDetails.getFunção());
                return funcionarioRepository.save(funcionario);
            });
    }

    public void deleteFuncionario(Long id) {
        funcionarioRepository.deleteById(id);
    }
}