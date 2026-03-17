package com.gestao.pedidos.repository;

import com.gestao.pedidos.model.Comanda;
import com.gestao.pedidos.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    List<Pedido> findByComanda(Comanda comanda);
}