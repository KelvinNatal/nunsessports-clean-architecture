package com.nunesports.nunesports.application.boundaries.input.register;

import com.nunesports.nunesports.application.model.request.ProdutoRequestModel;
import com.nunesports.nunesports.application.model.response.ProdutoResponseModel;

import java.util.UUID;

public interface IUpdateProdutoBoundary {
    ProdutoResponseModel updateById(UUID id, ProdutoRequestModel produtoRequestModel);
}
