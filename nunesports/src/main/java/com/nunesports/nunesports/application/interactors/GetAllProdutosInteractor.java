package com.nunesports.nunesports.application.interactors;

import com.nunesports.nunesports.application.boundaries.input.register.IGetAllProdutosBoundary;
import com.nunesports.nunesports.application.boundaries.output.register.IGetAllProdutosGateway;
import com.nunesports.nunesports.application.exception.ProdutoCustomException;
import com.nunesports.nunesports.application.model.response.ProdutoResponseModel;
import com.nunesports.nunesports.application.presenter.IProdutoPresenter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class GetAllProdutosInteractor implements IGetAllProdutosBoundary {
    IProdutoPresenter presenter;
    IGetAllProdutosGateway gateway;

    public GetAllProdutosInteractor(IProdutoPresenter presenter, IGetAllProdutosGateway gateway) {
        this.presenter = presenter;
        this.gateway = gateway;
    }

    @Override
    public Page<ProdutoResponseModel> findAll(Pageable pageable) throws ProdutoCustomException {
        Page<ProdutoResponseModel> model = gateway.findAll(pageable);
        if(model.isEmpty()){
            return presenter.prepareFailViewAll(new ProdutoCustomException("Nenhum produto encontrado"));
        }

        return presenter.prepareSuccessViewAll(model);
    }
}
