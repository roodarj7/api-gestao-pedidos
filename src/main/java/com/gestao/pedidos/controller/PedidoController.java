package com.gestao.pedidos.controller;

import com.gestao.pedidos.dto.PedidoRequest;
import com.gestao.pedidos.dto.PedidoResponse;
import com.gestao.pedidos.model.Comanda;
import com.gestao.pedidos.model.Pedido;
import com.gestao.pedidos.model.Produto;
import com.gestao.pedidos.repository.ComandaRepository;
import com.gestao.pedidos.repository.PedidoRepository;
import com.gestao.pedidos.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

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
    public PedidoResponse fazerPedido(@RequestBody PedidoRequest request) {

        Comanda comanda = comandaRepository.findById(request.comandaId()).get();
        Produto produto = produtoRepository.findById(request.produtoId()).get();

        Pedido novoPedido = new Pedido();
        novoPedido.setQuantidade(request.quantidade());
        novoPedido.setObservacao(request.observacao());
        novoPedido.setComanda(comanda);
        novoPedido.setProduto(produto);

        Pedido pedidoSalvo = pedidoRepository.save(novoPedido);

        return new PedidoResponse(produto.getNome(), pedidoSalvo.getQuantidade(), pedidoSalvo.getObservacao());
    }


    @GetMapping
    public List<PedidoResponse> listarPedidos() {

        List<Pedido> pedidosDoBanco = pedidoRepository.findAll();

        return pedidosDoBanco.stream().map(pedido -> new PedidoResponse(
                pedido.getProduto().getNome(),
                pedido.getQuantidade(),
                pedido.getObservacao()
        )).collect(Collectors.toList());
    }

}