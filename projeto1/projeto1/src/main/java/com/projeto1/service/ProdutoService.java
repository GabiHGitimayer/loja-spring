package com.projeto1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto1.entity.Produto;
import com.projeto1.repository.ProdutoRepository;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Produto> getAllProdutos() {
        return produtoRepository.findAll();
    }

    public Optional<Produto> getProdutoById(Long id) {
        return produtoRepository.findById(id);
    }

    public Produto createProduto(Produto produto) {
        return produtoRepository.save(produto);
    }

    public Optional<Produto> updateProduto(Long id, Produto produtoDetails) {
        return produtoRepository.findById(id)
            .map(produto -> {
                produto.setNome(produtoDetails.getNome());
                produto.setDescrição(produtoDetails.getDescrição());
                produto.setPreco(produtoDetails.getPreco());
                return produtoRepository.save(produto);
            });
    }

    public void deleteProduto(Long id) {
        produtoRepository.deleteById(id);
  
    }

    public List<Produto> findTop10Preco() {
        return produtoRepository.findTop10ByOrderByPrecoDesc();
    }    
}