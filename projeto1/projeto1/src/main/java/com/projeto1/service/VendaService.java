package com.projeto1.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.projeto1.entity.Venda;
import com.projeto1.repository.VendaRepository;

@Service
public class VendaService {

    @Autowired
    private VendaRepository vendaRepository;

    public List<Venda> getAllVendas() {
        return vendaRepository.findAll();
    }

    public Optional<Venda> getVendaById(Long id) {
        return vendaRepository.findById(id);
    }

    public Venda createVenda(Venda venda) {
        double total = venda.getProdutos().stream()
                            .mapToDouble(produto -> produto.getPreco())
                            .sum();
        venda.setValorTotal(total);
        return vendaRepository.save(venda);
    }

    public List<Venda> findByClienteNome(String nomeCliente) {
        return vendaRepository.findByClienteNome(nomeCliente);
    }

    public List<Venda> findByFuncionarioNome(String nomeFuncionario) {
        return vendaRepository.findByFuncionarioNome(nomeFuncionario);
    }


    public List<Venda> findTop10Valor() {
        return vendaRepository.findTop10ByOrderByValorTotalDesc();
    }
    
}