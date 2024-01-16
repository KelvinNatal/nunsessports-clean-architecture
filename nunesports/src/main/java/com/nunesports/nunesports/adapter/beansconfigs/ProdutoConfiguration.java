package com.nunesports.nunesports.adapter.beansconfigs;

import com.nunesports.nunesports.adapter.gateways.h2.ProdutoCriacaoH2Gateway;
import com.nunesports.nunesports.adapter.presenter.ProdutoPresenter;
import com.nunesports.nunesports.application.boundaries.input.register.*;
import com.nunesports.nunesports.application.boundaries.output.register.*;
import com.nunesports.nunesports.application.interactors.*;
import com.nunesports.nunesports.application.presenter.IProdutoPresenter;
import com.nunesports.nunesports.domain.factories.IProdutoFactory;
import com.nunesports.nunesports.domain.factories.ProdutoFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProdutoConfiguration {
    @Bean
    public IProdutoPresenter produtoPresenter() {
        return new ProdutoPresenter();
    }

    @Bean
    public IProdutoFactory produtoFactory() {
        return new ProdutoFactory();
    }

    @Bean
    public IProdutoRegisterGateway produtoRegisterGateway() {
        return new ProdutoCriacaoH2Gateway();
    }

    @Bean
    public IProdutoRegisterBoundary produtoInputBoundary(IProdutoPresenter produtoPresenter, IProdutoFactory produtoFactory, IProdutoRegisterGateway produtoRegisterGateway) {
        return new CreateProdutoInteractor(produtoPresenter, produtoFactory, produtoRegisterGateway);
    }

    @Bean
    public IGetAllProdutosBoundary getAllProdutosBoundary(IProdutoPresenter produtoPresenter, IGetAllProdutosGateway getAllProdutosGateway){
        return new GetAllProdutosInteractor(produtoPresenter, getAllProdutosGateway);
    }

    @Bean
    public IGetProdutoBoundary getProdutoBoundary(IProdutoPresenter produtoPresenter, IGetProdutoGateway getProdutoGateway){
        return new GetProdutoInteractor(produtoPresenter, getProdutoGateway);
    }

    @Bean
    public IUpdateProdutoBoundary updateProdutoBoundary(IProdutoPresenter produtoPresenter, IUpdateProdutoGateway updateProdutoGateway, IGetProdutoGateway getProdutoGateway){
        return new UpdateProdutoInteractor(produtoPresenter, updateProdutoGateway, getProdutoGateway);
    }

    @Bean
    public IDeleteProdutosBoundary deleteProdutosBoundary(IProdutoPresenter produtoPresenter, IDeleteProdutosGateway deleteProdutosGateway, IGetProdutoGateway getProdutoGateway){
        return new DeleteProdutosInteractor(produtoPresenter, deleteProdutosGateway, getProdutoGateway);
    }
}
