package com.nunesports.nunesports.application.boundaries.input.register;

import com.nunesports.nunesports.application.exception.ProdutoCustomException;
import com.nunesports.nunesports.application.model.request.ProdutoRequestModel;
import com.nunesports.nunesports.application.model.response.ProdutoResponseModel;

public interface IProdutoRegisterBoundary {
    ProdutoResponseModel create(ProdutoRequestModel requestModel) throws ProdutoCustomException;
}
