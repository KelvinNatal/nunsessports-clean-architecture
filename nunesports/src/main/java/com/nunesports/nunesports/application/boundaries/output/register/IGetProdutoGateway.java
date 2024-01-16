package com.nunesports.nunesports.application.boundaries.output.register;

import com.nunesports.nunesports.application.model.response.ProdutoResponseModel;

import java.util.UUID;

public interface IGetProdutoGateway {
    ProdutoResponseModel findById(UUID id);
}
