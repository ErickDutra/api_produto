package com.produto.produto_app.service;

import org.springframework.stereotype.Service;
import com.produto.produto_app.repository.CategoriaRepository;
import com.produto.produto_app.table.Categoria;
import com.produto.produto_app.dto.CategoriaDto;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoriaService {
    
    private CategoriaRepository categoriaRepository;

    public CategoriaDto cadastrarCategoria(CategoriaDto categoriadto){ 
        Categoria categoriaDb = new Categoria();
        categoriaDb.setNome(categoriadto.nome());
        return new CategoriaDto(categoriaRepository.save(categoriaDb).getId(), categoriaDb.getNome());
    }

    public List<CategoriaDto> getCategoria() {
        return categoriaRepository.findAll().stream().map(categoria -> new CategoriaDto(categoria.getId(),categoria.getNome())).collect(Collectors.toList());
    }

    public void deleteById(Long id) {
        categoriaRepository.deleteById(id);
    }
}
