package com.gestao.pedidos.controller;

import com.gestao.pedidos.dto.ProdutoRequest;
import com.gestao.pedidos.model.Produto;
import com.gestao.pedidos.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoRepository repository;

    @PostMapping
    public Produto cadastrarProduto(@RequestBody ProdutoRequest request) {
        Produto novoProduto = new Produto();

        novoProduto.setNome(request.nome());
        novoProduto.setPreco(request.preco());
        novoProduto.setDescricao(request.descricao());

        return repository.save(novoProduto);
    }

    @GetMapping
    public List<Produto> listarProdutos() {
        return repository.findAll();
    }
}