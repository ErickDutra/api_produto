package com.produto.produto_app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import com.produto.produto_app.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.produto.produto_app.dto.CategoriaDto;
import org.springframework.http.ResponseEntity;
import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;





@Controller
@RequestMapping("/api/categorias")
@CrossOrigin("*")
public class CategoriaController {

    @Autowired  
    private CategoriaService categoriaService;

    @PostMapping("/save")
    public ResponseEntity<CategoriaDto> cadastrarCategoria(@RequestBody CategoriaDto categoria) {
        return ResponseEntity.ok(categoriaService.cadastrarCategoria(categoria));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<CategoriaDto>> getCategorias() {
        return ResponseEntity.ok(categoriaService.getCategoria());
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<Void> deletarCategoria(@PathVariable Long id) {
        categoriaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    
}
