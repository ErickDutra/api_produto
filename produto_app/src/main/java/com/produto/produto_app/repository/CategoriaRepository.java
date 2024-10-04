package com.produto.produto_app.repository;

import com.produto.produto_app.table.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    
}
