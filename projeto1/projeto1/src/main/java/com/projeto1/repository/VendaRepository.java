package com.projeto1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto1.entity.Venda;

public interface VendaRepository extends JpaRepository<Venda, Long> {
	List<Venda> findByClienteNome(String nomeCliente);
    List<Venda> findByFuncionarioNome(String nomeFuncionario);
    List<Venda> findTop10ByOrderByValorTotalDesc();

}
