package com.nunesports.nunesports.application.interactors;

import com.nunesports.nunesports.application.boundaries.input.register.IUpdateProdutoBoundary;
import com.nunesports.nunesports.application.boundaries.output.register.IGetProdutoGateway;
import com.nunesports.nunesports.application.boundaries.output.register.IUpdateProdutoGateway;
import com.nunesports.nunesports.application.exception.ProdutoCustomException;
import com.nunesports.nunesports.application.model.request.ProdutoRequestModel;
import com.nunesports.nunesports.application.model.response.ProdutoResponseModel;
import com.nunesports.nunesports.application.presenter.IProdutoPresenter;

import java.util.UUID;

public class UpdateProdutoInteractor implements IUpdateProdutoBoundary {
    IProdutoPresenter presenter;
    IGetProdutoGateway getProdutoGateway;
    IUpdateProdutoGateway gateway;

    public UpdateProdutoInteractor(IProdutoPresenter presenter, IUpdateProdutoGateway gateway, IGetProdutoGateway getProdutoGateway) {
        this.presenter = presenter;
        this.gateway = gateway;
        this.getProdutoGateway = getProdutoGateway;
    }

    @Override
    public ProdutoResponseModel updateById(UUID id, ProdutoRequestModel produtoRequestModel) {
        getProdutoGateway.findById(id);

        if(produtoRequestModel.getNome() == null) return presenter.prepareFailView(new ProdutoCustomException("O campo nome é obrigatório"));
        if(produtoRequestModel.getCodigo() == null) return presenter.prepareFailView(new ProdutoCustomException("O campo código é obrigatório"));
        if(produtoRequestModel.getDescricao() == null) return presenter.prepareFailView(new ProdutoCustomException("O campo descricao é obrigatório"));
        if(produtoRequestModel.getPreco() == 0) return presenter.prepareFailView(new ProdutoCustomException("O campo preco é obrigatório"));

        ProdutoResponseModel produtoResponseModel = gateway.save(id, produtoRequestModel);

        return presenter.prepareSuccessView(produtoResponseModel);
    }
}
