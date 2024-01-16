package com.nunesports.nunesports.domain.factories;

import com.nunesports.nunesports.domain.IProduto;

import java.util.UUID;

public interface IProdutoFactory {
    IProduto create(UUID id, String nome, String codigo, String descricao, double preco);
}
