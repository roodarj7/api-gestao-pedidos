package com.gestao.pedidos.dto;

public record PedidoRequest(Long comandaId, Long produtoId, Integer quantidade, String observacao) {
}