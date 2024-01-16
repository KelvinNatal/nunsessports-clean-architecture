package com.nunesports.nunesports.adapter.gateways.mapper;

import com.nunesports.nunesports.application.model.response.ProdutoResponseModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.util.List;
import java.util.stream.Collectors;

public class ProdutoMapper {
    public static ProdutoResponseModel toRespondeModel(ProdutoJpaMapper jpaMapper) {
        ProdutoResponseModel produtoResponseModel = new ProdutoResponseModel();

        produtoResponseModel.setId(jpaMapper.getId());
        produtoResponseModel.setNome(jpaMapper.getNome());
        produtoResponseModel.setCodigo(jpaMapper.getCodigo());
        produtoResponseModel.setDescricao(jpaMapper.getDescricao());
        produtoResponseModel.setPreco(jpaMapper.getPreco());

        return produtoResponseModel;
    }

    public static Page<ProdutoResponseModel> listJPAtoRespondeModel(Page<ProdutoJpaMapper> pageJpaMapper) {
        List<ProdutoResponseModel> responseModels = pageJpaMapper.getContent()
                .stream()
                .map(ProdutoMapper::toRespondeModel)
                .collect(Collectors.toList());

        return new PageImpl<>(responseModels, pageJpaMapper.getPageable(), pageJpaMapper.getTotalElements());
    }

}
