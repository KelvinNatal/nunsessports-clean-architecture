package com.nunesports.nunesports.application.model.response;

import java.util.UUID;

public class ProdutoResponseModel {
    private UUID id;
    private String nome;
    private String codigo;
    private String descricao;
    private double preco;

    public ProdutoResponseModel() {}

    public ProdutoResponseModel(UUID id, String nome, String codigo, String descricao, double preco) {
        this.id = id;
        this.nome = nome;
        this.codigo = codigo;
        this.descricao = descricao;
        this.preco = preco;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProdutoResponseModel that = (ProdutoResponseModel) o;

        if (Double.compare(that.preco, preco) != 0) return false;
        if (!id.equals(that.id)) return false;
        if (!nome.equals(that.nome)) return false;
        if (!codigo.equals(that.codigo)) return false;
        return descricao.equals(that.descricao);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id.hashCode();
        result = 31 * result + nome.hashCode();
        result = 31 * result + codigo.hashCode();
        result = 31 * result + descricao.hashCode();
        temp = Double.doubleToLongBits(preco);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
