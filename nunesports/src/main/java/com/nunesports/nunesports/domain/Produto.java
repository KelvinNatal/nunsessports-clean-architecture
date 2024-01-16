package com.nunesports.nunesports.domain;

import java.util.UUID;

public class Produto implements IProduto {
    private UUID id;
    private String nome;
    private String codigo;
    private String descricao;
    private double preco;

    public Produto(UUID id, String nome, String codigo, String descricao, double preco) {
        this.id = id;
        this.nome = nome;
        this.codigo = codigo;
        this.descricao = descricao;
        this.preco = preco;
    }

    @Override
    public UUID getId() {
        return id;
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public String getCodigo() {
        return codigo;
    }

    @Override
    public String getDescricao() {
        return descricao;
    }

    @Override
    public double getPreco() {
        return preco;
    }
}
