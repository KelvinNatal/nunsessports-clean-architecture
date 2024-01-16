package com.nunesports.nunesports.application.boundaries.input.register;

import com.nunesports.nunesports.application.model.response.ProdutoResponseModel;

import java.util.UUID;

public interface IGetProdutoBoundary {
    ProdutoResponseModel findById(UUID id);
}
