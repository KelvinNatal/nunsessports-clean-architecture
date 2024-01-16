package com.nunesports.nunesports.application.presenter;

import com.nunesports.nunesports.application.exception.ProdutoCustomException;
import com.nunesports.nunesports.application.model.request.ProdutoRequestModel;
import com.nunesports.nunesports.application.model.response.ProdutoResponseModel;
import org.springframework.data.domain.Page;

public interface IProdutoPresenter{
    ProdutoResponseModel prepareFailView(ProdutoCustomException e) throws ProdutoCustomException;
    ProdutoResponseModel prepareSuccessView(ProdutoResponseModel responseModel);
    Page<ProdutoResponseModel> prepareFailViewAll(ProdutoCustomException e) throws ProdutoCustomException;
    Page<ProdutoResponseModel> prepareSuccessViewAll(Page<ProdutoResponseModel> produtoResponseModels);

    void prepareSuccessViewVoid();
}
