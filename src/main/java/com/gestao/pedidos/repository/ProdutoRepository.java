package com.gestao.pedidos.repository;

import com.gestao.pedidos.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}