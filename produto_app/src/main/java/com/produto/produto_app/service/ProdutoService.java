package com.produto.produto_app.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.produto.produto_app.dto.ProdutoDto;
import com.produto.produto_app.repository.ProdutoRepository;
import com.produto.produto_app.table.Produto;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ProdutoService {
    
    @Autowired
    private ProdutoRepository produtoRepository;


    public List<ProdutoDto> getProduto() {
        return produtoRepository.findAll().stream().map(produto -> new ProdutoDto(produto.getId(),produto.getProduto(),produto.getPreco(), produto.getCategoria())).collect(Collectors.toList());
    }
    

    public ProdutoDto saveProduto(ProdutoDto produto) {
        Produto produtoDb = new Produto();
        produtoDb.setPreco(produto.preco());
        produtoDb.setProduto(produto.produto());
        produtoDb.setCategoria(produto.categoria());
        produtoRepository.save(produtoDb);
        return new ProdutoDto(produtoDb.getId(), produtoDb.getProduto(), produtoDb.getPreco(), produtoDb.getCategoria());
    }

    public void deleteProduto(Long id) {
        Produto produto = produtoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Produto não encontrado com ID: " + id));
        produtoRepository.delete(produto);
    }

}
