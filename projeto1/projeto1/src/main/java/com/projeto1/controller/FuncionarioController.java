package com.projeto1.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.projeto1.entity.Funcionario;
import com.projeto1.repository.FuncionarioRepository;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @GetMapping
    public List<Funcionario> getAllFuncionarios() {
        return funcionarioRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Funcionario> getFuncionarioById(@PathVariable Long id) {
        return funcionarioRepository.findById(id)
            .map(funcionario -> ResponseEntity.ok().body(funcionario))
            .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Funcionario createFuncionario(@RequestBody Funcionario funcionario) {
        return funcionarioRepository.save(funcionario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Funcionario> updateFuncionario(@PathVariable Long id, @RequestBody Funcionario funcionarioDetails) {
        return funcionarioRepository.findById(id)
            .map(funcionario -> {
                funcionario.setNome(funcionarioDetails.getNome());
                funcionario.setEmail(funcionarioDetails.getEmail());
                funcionario.setTelefone(funcionarioDetails.getTelefone());
                funcionario.setIdade(funcionarioDetails.getIdade());
                funcionario.setEndereço(funcionarioDetails.getEndereço());
                funcionario.setFunção(funcionarioDetails.getFunção());
                return ResponseEntity.ok().body(funcionarioRepository.save(funcionario));
            }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteFuncionario(@PathVariable Long id) {
        return funcionarioRepository.findById(id)
            .map(funcionario -> {
                funcionarioRepository.delete(funcionario);
                return ResponseEntity.noContent().build();
            }).orElse(ResponseEntity.notFound().build());
    }
}
