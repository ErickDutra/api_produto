package com.produto.produto_app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.produto.produto_app.dto.ProdutoDto;
import com.produto.produto_app.service.ProdutoService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@CrossOrigin("*")
@Controller
@RequestMapping("/api/produtos")
public class ProdutoController {

    @Autowired
    ProdutoService produtoService;


    @GetMapping("/getAll")
    public ResponseEntity<List<ProdutoDto>> getProdutos() {
        List<ProdutoDto> produtos = produtoService.getProduto();
        return ResponseEntity.ok(produtos);
    }

    @PostMapping("/save")
    public ResponseEntity<ProdutoDto> postProduto(@RequestBody ProdutoDto produto) {
        ProdutoDto produtoDto = produtoService.saveProduto(produto);
        return ResponseEntity.ok(produtoDto);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteProduto(@PathVariable("id") Long id) {
       produtoService.deleteProduto(id);
        return ResponseEntity.ok().build();
    }
    

}
