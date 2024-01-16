package com.nunesports.nunesports.adapter.gateways.h2;

import com.nunesports.nunesports.adapter.gateways.mapper.ProdutoJpaMapper;
import com.nunesports.nunesports.adapter.gateways.mapper.ProdutoMapper;
import com.nunesports.nunesports.adapter.repositories.IProdutoRepository;
import com.nunesports.nunesports.application.boundaries.output.register.IUpdateProdutoGateway;
import com.nunesports.nunesports.application.model.request.ProdutoRequestModel;
import com.nunesports.nunesports.application.model.response.ProdutoResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class ProdutoUpdateH2Gateway implements IUpdateProdutoGateway {
    @Autowired
    IProdutoRepository _repository;

    public ProdutoUpdateH2Gateway() {}

    @Override
    public ProdutoResponseModel save(UUID id, ProdutoRequestModel produtoRequestModel) {
        ProdutoJpaMapper produto = new ProdutoJpaMapper(id, produtoRequestModel.getNome(), produtoRequestModel.getCodigo(), produtoRequestModel.getDescricao(), produtoRequestModel.getPreco());
        _repository.save(produto);

        return ProdutoMapper.toRespondeModel(produto);
    }
}
