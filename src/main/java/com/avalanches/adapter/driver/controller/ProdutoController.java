package com.avalanches.adapter.driver.controller;

import com.avalanches.adapter.driver.Convert;
import com.avalanches.adapter.driver.dto.ProdutoRequest;
import com.avalanches.adapter.driver.dto.ProdutoResponse;
import com.avalanches.core.application.usecases.ProdutoUseCasePort;
import com.avalanches.core.domain.entities.Produto;
import com.avalanches.core.domain.entities.CategoriaProduto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/avalanches/v1/produto")
@Validated
public class ProdutoController {

    @Autowired
    private ProdutoUseCasePort produtoUseCasePort;

    @PostMapping
    public ResponseEntity<Void> create(@Valid  @RequestBody ProdutoRequest produto) {
        produtoUseCasePort.insertProduto(Convert.produtoRequestToProduto(produto));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable int id, @Valid @RequestBody ProdutoRequest produto) {
        Produto produtoEntity = Convert.produtoRequestToProduto(produto);
        produtoEntity.id = id;
        produtoUseCasePort.updateProduto(produtoEntity);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        produtoUseCasePort.deleteProduto(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/{categoriaProduto}")
    public ResponseEntity<List<ProdutoResponse>> get(@PathVariable("categoriaProduto") CategoriaProduto categoriaProduto){

        var response = Convert.listProdutoToListProdutoResponse(produtoUseCasePort.getProdutos(categoriaProduto));

        return ResponseEntity.ok().body(response);
    }

}
