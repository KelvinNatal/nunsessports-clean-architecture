package com.nunesports.nunesports.application.boundaries.output.register;

import com.nunesports.nunesports.application.model.response.ProdutoResponseModel;
import com.nunesports.nunesports.domain.IProduto;

public interface IProdutoRegisterGateway extends IProdutoExisteGateway {
    ProdutoResponseModel save(IProduto iProduto);
}
