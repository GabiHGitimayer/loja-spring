package com.projeto1.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.projeto1.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
	List<Cliente> findByIdadeBetween(int start, int end);
   }
