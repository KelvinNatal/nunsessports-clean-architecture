package com.nunesports.nunesports.adapter.gateways.h2;

import com.nunesports.nunesports.adapter.gateways.mapper.ProdutoJpaMapper;
import com.nunesports.nunesports.adapter.gateways.mapper.ProdutoMapper;
import com.nunesports.nunesports.adapter.repositories.IProdutoRepository;
import com.nunesports.nunesports.application.boundaries.output.register.IGetAllProdutosGateway;
import com.nunesports.nunesports.application.model.response.ProdutoResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
public class ProdutoGetAllH2Gateway implements IGetAllProdutosGateway {

    @Autowired
    IProdutoRepository _repository;

    public ProdutoGetAllH2Gateway() {}

    @Override
    public Page<ProdutoResponseModel> findAll(Pageable pageable) {
        Page<ProdutoJpaMapper> produtos = _repository.findAll(pageable);
        return ProdutoMapper.listJPAtoRespondeModel(produtos);
    }
}
