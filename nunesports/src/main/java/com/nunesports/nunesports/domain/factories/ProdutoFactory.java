package com.nunesports.nunesports.domain.factories;

import com.nunesports.nunesports.domain.IProduto;
import com.nunesports.nunesports.domain.Produto;

import java.util.UUID;

public class ProdutoFactory implements IProdutoFactory{
    @Override
    public IProduto create(UUID id, String nome, String codigo, String descricao, double preco) {
        return new Produto(id, nome, codigo, descricao, preco);
    }
}
