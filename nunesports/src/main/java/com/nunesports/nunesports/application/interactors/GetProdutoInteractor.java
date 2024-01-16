package com.nunesports.nunesports.application.interactors;

import com.nunesports.nunesports.application.boundaries.input.register.IGetProdutoBoundary;
import com.nunesports.nunesports.application.boundaries.output.register.IGetAllProdutosGateway;
import com.nunesports.nunesports.application.boundaries.output.register.IGetProdutoGateway;
import com.nunesports.nunesports.application.model.response.ProdutoResponseModel;
import com.nunesports.nunesports.application.presenter.IProdutoPresenter;

import java.util.UUID;

public class GetProdutoInteractor implements IGetProdutoBoundary {

    IProdutoPresenter presenter;
    IGetProdutoGateway gateway;

    public GetProdutoInteractor(IProdutoPresenter presenter, IGetProdutoGateway gateway) {
        this.presenter = presenter;
        this.gateway = gateway;
    }

    @Override
    public ProdutoResponseModel findById(UUID id) {
        ProdutoResponseModel produtoResponseModel = gateway.findById(id);

        return presenter.prepareSuccessView(produtoResponseModel);
    }
}
