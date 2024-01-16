package com.nunesports.nunesports.application.interactors;

import com.nunesports.nunesports.application.boundaries.output.register.IProdutoRegisterGateway;
import com.nunesports.nunesports.application.boundaries.input.register.IProdutoRegisterBoundary;
import com.nunesports.nunesports.application.exception.ProdutoCustomException;
import com.nunesports.nunesports.application.model.request.ProdutoRequestModel;
import com.nunesports.nunesports.application.model.response.ProdutoResponseModel;
import com.nunesports.nunesports.application.presenter.IProdutoPresenter;
import com.nunesports.nunesports.domain.IProduto;
import com.nunesports.nunesports.domain.factories.IProdutoFactory;

import java.util.UUID;

public class CreateProdutoInteractor implements IProdutoRegisterBoundary {
    IProdutoPresenter presenter;
    IProdutoFactory factory;
    IProdutoRegisterGateway gateway;

    public CreateProdutoInteractor(IProdutoPresenter presenter, IProdutoFactory factory, IProdutoRegisterGateway gateway) {
        this.presenter = presenter;
        this.factory = factory;
        this.gateway = gateway;
    }

    @Override
    public ProdutoResponseModel create(ProdutoRequestModel requestModel) throws ProdutoCustomException {
        if(gateway.existsByNome(requestModel.getNome())){
            return presenter.prepareFailView(new ProdutoCustomException("Produto com o nome " + requestModel.getNome() + " ja existe"));
        }

        IProduto produto = factory.create(UUID.randomUUID(), requestModel.getNome(), requestModel.getCodigo(), requestModel.getDescricao(), requestModel.getPreco());

        gateway.save(produto);

        ProdutoResponseModel responseModel = new ProdutoResponseModel(produto.getId(), produto.getNome(), produto.getCodigo(), produto.getDescricao(), produto.getPreco());

        return presenter.prepareSuccessView(responseModel);
    }
}
