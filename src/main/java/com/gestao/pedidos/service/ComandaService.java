package com.gestao.pedidos.service;

import com.gestao.pedidos.model.Comanda;
import com.gestao.pedidos.model.Pedido;
import com.gestao.pedidos.repository.ComandaRepository;
import com.gestao.pedidos.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComandaService {


    @Autowired
    private ComandaRepository comandaRepository;

    @Autowired
    private PedidoRepository pedidoRepository;

    public String fecharMesaEPagar(Long id) {

        Comanda comanda = comandaRepository.findById(id).get();

        List<Pedido> itensConsumidos = pedidoRepository.findByComanda(comanda);

        double totalDaConta = 0.0;
        for (Pedido pedido : itensConsumidos) {
            double valorDoItem = pedido.getProduto().getPreco() * pedido.getQuantidade();
            totalDaConta = totalDaConta + valorDoItem;
        }

        comanda.setStatus("PAGA");
        comandaRepository.save(comanda);

        return "Comanda da Mesa " + comanda.getNumeroMesa() +
                " fechada com sucesso! Valor total a pagar: R$ " + totalDaConta;
    }
}