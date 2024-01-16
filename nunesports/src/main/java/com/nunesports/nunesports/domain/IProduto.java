package com.nunesports.nunesports.domain;

import java.util.UUID;

public interface IProduto {
    UUID getId();
    String getNome();
    String getCodigo();
    String getDescricao();
    double getPreco();
}
