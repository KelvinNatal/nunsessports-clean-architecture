package com.nunesports.nunesports.adapter.gateways.h2;

import com.nunesports.nunesports.adapter.gateways.mapper.ProdutoJpaMapper;
import com.nunesports.nunesports.adapter.gateways.mapper.ProdutoMapper;
import com.nunesports.nunesports.adapter.repositories.IProdutoRepository;
import com.nunesports.nunesports.application.boundaries.output.register.IGetProdutoGateway;
import com.nunesports.nunesports.application.exception.ProdutoCustomException;
import com.nunesports.nunesports.application.model.response.ProdutoResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class ProdutoGetH2Gateway implements IGetProdutoGateway {
    @Autowired
    IProdutoRepository _repository;

    public ProdutoGetH2Gateway() {}

    @Override
    public ProdutoResponseModel findById(UUID id) {
        ProdutoJpaMapper produto = _repository.findById(id).orElseThrow(() -> new ProdutoCustomException("Produto não encontrado"));
        return ProdutoMapper.toRespondeModel(produto);
    }
}
