package com.nunesports.nunesports.application.boundaries.output.register;

import com.nunesports.nunesports.application.model.request.ProdutoRequestModel;
import com.nunesports.nunesports.application.model.response.ProdutoResponseModel;

import java.util.UUID;

public interface IUpdateProdutoGateway {
    ProdutoResponseModel save(UUID id, ProdutoRequestModel produtoRequestModel);
}
