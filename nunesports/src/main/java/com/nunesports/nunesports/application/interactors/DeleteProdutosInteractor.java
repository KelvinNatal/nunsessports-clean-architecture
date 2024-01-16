package com.nunesports.nunesports.application.interactors;

import com.nunesports.nunesports.application.boundaries.input.register.IDeleteProdutosBoundary;
import com.nunesports.nunesports.application.boundaries.output.register.IDeleteProdutosGateway;
import com.nunesports.nunesports.application.boundaries.output.register.IGetProdutoGateway;
import com.nunesports.nunesports.application.exception.ProdutoCustomException;
import com.nunesports.nunesports.application.model.response.ProdutoResponseModel;
import com.nunesports.nunesports.application.presenter.IProdutoPresenter;

import java.util.UUID;

public class DeleteProdutosInteractor implements IDeleteProdutosBoundary {
    IProdutoPresenter presenter;
    IDeleteProdutosGateway gateway;
    IGetProdutoGateway getProdutoGatewayy;

    public DeleteProdutosInteractor(IProdutoPresenter presenter, IDeleteProdutosGateway gateway, IGetProdutoGateway getProdutoGatewayy) {
        this.presenter = presenter;
        this.gateway = gateway;
        this.getProdutoGatewayy = getProdutoGatewayy;
    }
    @Override
    public void delete(UUID id) {
        getProdutoGatewayy.findById(id);
        gateway.delete(id);

        presenter.prepareSuccessViewVoid();
    }
}
