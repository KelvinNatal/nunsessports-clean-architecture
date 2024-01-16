package com.nunesports.nunesports.application.boundaries.output.register;

import com.nunesports.nunesports.application.model.response.ProdutoResponseModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IGetAllProdutosGateway {
    Page<ProdutoResponseModel> findAll(Pageable pageable);
}
