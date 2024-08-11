package com.projeto1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.projeto1.entity.Venda;
import com.projeto1.service.VendaService;


@RequestMapping("/vendas")
public class VendaController {

    @Autowired
    private VendaService vendaService;

    @GetMapping
    public List<Venda> getAllVendas() {
        return vendaService.getAllVendas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Venda> getVendaById(@PathVariable Long id) {
        return vendaService.getVendaById(id)
            .map(venda -> ResponseEntity.ok().body(venda))
            .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Venda createVenda(@RequestBody Venda venda) {
        return vendaService.createVenda(venda);
    }

    
    @GetMapping("/cliente")
    public List<Venda> findByClienteNome(@RequestParam String nome) {
        return vendaService.findByClienteNome(nome);
    }

    @GetMapping("/funcionario")
    public List<Venda> findVendasByFuncionarioNome(@RequestParam String nome) {
        return vendaService.findByFuncionarioNome(nome);
    }

    @GetMapping("/top-produtos")
    public List<Venda> findTop10Valor() {
        return vendaService.findTop10Valor();
    }
}