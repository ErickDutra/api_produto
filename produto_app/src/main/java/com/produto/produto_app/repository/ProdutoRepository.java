package com.produto.produto_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.produto.produto_app.table.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    
}
