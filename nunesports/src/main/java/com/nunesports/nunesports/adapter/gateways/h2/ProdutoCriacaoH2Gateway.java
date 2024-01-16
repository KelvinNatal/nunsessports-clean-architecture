package com.nunesports.nunesports.adapter.gateways.h2;

import com.nunesports.nunesports.adapter.gateways.mapper.ProdutoJpaMapper;
import com.nunesports.nunesports.adapter.gateways.mapper.ProdutoMapper;
import com.nunesports.nunesports.adapter.repositories.IProdutoRepository;
import com.nunesports.nunesports.application.boundaries.output.register.IProdutoRegisterGateway;
import com.nunesports.nunesports.application.model.response.ProdutoResponseModel;
import com.nunesports.nunesports.domain.IProduto;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

public class ProdutoCriacaoH2Gateway implements IProdutoRegisterGateway {
    @Autowired
    IProdutoRepository _repository;

    public ProdutoCriacaoH2Gateway() {}

    @Override
    public boolean existsByNome(String nome) {
        return _repository.existsByNome(nome);
    }

    @Override
    public ProdutoResponseModel save(IProduto iProduto) {
        ProdutoJpaMapper produtoJpaMapper = new ProdutoJpaMapper(iProduto.getId(), iProduto.getNome(), iProduto.getCodigo(), iProduto.getDescricao(), iProduto.getPreco());
        _repository.save(produtoJpaMapper);

        return ProdutoMapper.toRespondeModel(produtoJpaMapper);
    }
}
