package com.nunesports.nunesports.application.boundaries.input.register;

import com.nunesports.nunesports.application.exception.ProdutoCustomException;
import com.nunesports.nunesports.application.model.response.ProdutoResponseModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IGetAllProdutosBoundary {
    Page<ProdutoResponseModel> findAll(Pageable pageable);
}
