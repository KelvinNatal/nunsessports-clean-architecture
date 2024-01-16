package com.nunesports.nunesports.adapter.presenter;

import com.nunesports.nunesports.application.exception.ProdutoCustomException;
import com.nunesports.nunesports.application.model.response.ProdutoResponseModel;
import com.nunesports.nunesports.application.presenter.IProdutoPresenter;
import org.springframework.data.domain.Page;

public class ProdutoPresenter implements IProdutoPresenter {
    @Override
    public ProdutoResponseModel prepareFailView(ProdutoCustomException e) throws ProdutoCustomException {
        throw  e;
    }
    @Override
    public ProdutoResponseModel prepareSuccessView(ProdutoResponseModel responseModel) {
        return responseModel;
    }

    @Override
    public Page<ProdutoResponseModel> prepareFailViewAll(ProdutoCustomException e) throws ProdutoCustomException {
        throw  e;
    }
    @Override
    public Page<ProdutoResponseModel> prepareSuccessViewAll(Page<ProdutoResponseModel> produtoResponseModels) {
        return produtoResponseModels;
    }

    @Override
    public void prepareSuccessViewVoid() {}
}
