package com.gestao.pedidos.controller;

import com.gestao.pedidos.dto.PedidoRequest;
import com.gestao.pedidos.model.Comanda;
import com.gestao.pedidos.model.Pedido;
import com.gestao.pedidos.model.Produto;
import com.gestao.pedidos.repository.ComandaRepository;
import com.gestao.pedidos.repository.PedidoRepository;
import com.gestao.pedidos.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoRepository pedidoRepository;
    @Autowired
    private ComandaRepository comandaRepository;
    @Autowired
    private ProdutoRepository produtoRepository;

    @PostMapping
    public Pedido fazerPedido(@RequestBody PedidoRequest request) {


        Comanda comanda = comandaRepository.findById(request.comandaId()).get();
        Produto produto = produtoRepository.findById(request.produtoId()).get();

        Pedido novoPedido = new Pedido();
        novoPedido.setQuantidade(request.quantidade());
        novoPedido.setObservacao(request.observacao());

        novoPedido.setComanda(comanda);
        novoPedido.setProduto(produto);

        return pedidoRepository.save(novoPedido);
    }
}