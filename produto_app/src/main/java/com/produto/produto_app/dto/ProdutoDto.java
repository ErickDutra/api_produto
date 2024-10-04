package com.produto.produto_app.dto;

import com.produto.produto_app.table.Categoria;

public record ProdutoDto(String id, String produto, Double preco, Categoria categoria ){
}
