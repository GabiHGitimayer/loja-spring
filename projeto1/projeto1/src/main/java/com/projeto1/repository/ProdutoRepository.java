package com.projeto1.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.projeto1.entity.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
	List<Produto> findTop10ByOrderByPrecoDesc();
}
