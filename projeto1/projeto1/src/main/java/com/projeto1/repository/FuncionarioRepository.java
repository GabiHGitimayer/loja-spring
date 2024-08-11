package com.projeto1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.projeto1.entity.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

}
