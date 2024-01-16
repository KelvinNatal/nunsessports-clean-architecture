package com.nunesports.nunesports.adapter.gateways.h2;

import com.nunesports.nunesports.adapter.repositories.IProdutoRepository;
import com.nunesports.nunesports.application.boundaries.output.register.IDeleteProdutosGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class ProdutoDeleteH2Gateway implements IDeleteProdutosGateway {

    @Autowired
    IProdutoRepository _repository;

    public ProdutoDeleteH2Gateway() {}

    @Override
    public void delete(UUID id) {
        _repository.deleteById(id);
    }
}
