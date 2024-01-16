package com.nunesports.nunesports.adapter.controller.register;

import com.nunesports.nunesports.application.boundaries.input.register.*;
import com.nunesports.nunesports.application.exception.ProdutoCustomException;
import com.nunesports.nunesports.application.model.request.ProdutoRequestModel;
import com.nunesports.nunesports.application.model.response.ProdutoResponseModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController()
@RequestMapping("/v1/produtos")
public class ProdutoController {
    IProdutoRegisterBoundary inputBoundary;
    IGetAllProdutosBoundary getAllProdutosBoundary;
    IGetProdutoBoundary getProdutoBoundary;

    IUpdateProdutoBoundary updateProdutoBoundary;
    IDeleteProdutosBoundary deleteProdutosBoundary;

    public ProdutoController(IProdutoRegisterBoundary inputBoundary, IGetAllProdutosBoundary getAllProdutosBoundary, IGetProdutoBoundary getProdutoBoundary, IUpdateProdutoBoundary updateProdutoBoundary, IDeleteProdutosBoundary deleteProdutosBoundary) {
        this.inputBoundary = inputBoundary;
        this.getAllProdutosBoundary = getAllProdutosBoundary;
        this.updateProdutoBoundary = updateProdutoBoundary;
        this.getProdutoBoundary = getProdutoBoundary;
        this.deleteProdutosBoundary = deleteProdutosBoundary;
    }

    @GetMapping
    public ResponseEntity<Page<ProdutoResponseModel>> findAll(Pageable pageable) {
        Page<ProdutoResponseModel> produtoResponseModel= getAllProdutosBoundary.findAll(pageable);
        return ResponseEntity.ok(produtoResponseModel);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoResponseModel> findById(@PathVariable UUID id) {
        ProdutoResponseModel produtoResponseModel= getProdutoBoundary.findById(id);
        return ResponseEntity.ok(produtoResponseModel);
    }

    @PostMapping
    public ResponseEntity<ProdutoResponseModel> create(@RequestBody ProdutoRequestModel requestModel) throws ProdutoCustomException {
        ProdutoResponseModel produtoResponseModel = inputBoundary.create(requestModel);
        return ResponseEntity.ok(produtoResponseModel);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProdutoResponseModel> create(@PathVariable UUID id, @RequestBody ProdutoRequestModel requestModel) throws ProdutoCustomException {
        ProdutoResponseModel produtoResponseModel = updateProdutoBoundary.updateById(id,requestModel);

        return ResponseEntity.ok(produtoResponseModel);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable UUID id){
        deleteProdutosBoundary.delete(id);

        return ResponseEntity.noContent().build();
    }
}
