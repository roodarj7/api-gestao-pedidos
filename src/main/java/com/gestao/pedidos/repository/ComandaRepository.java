package com.gestao.pedidos.repository;

import com.gestao.pedidos.model.Comanda;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComandaRepository extends JpaRepository<Comanda, Long> {
}