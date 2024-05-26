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
public class ProdutoController implements ProdutoControllerDoc {

    @Autowired
    private ProdutoUseCasePort produtoUseCasePort;

    @PostMapping
    @Override
    public ResponseEntity<Void> cadastrar(@Valid @RequestBody ProdutoRequest produto) {
        produtoUseCasePort.cadastrarProduto(Convert.produtoRequestToProduto(produto));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    @Override
    public ResponseEntity<Void> atualizar(@PathVariable int id, @Valid @RequestBody ProdutoRequest produto) {
        Produto produtoEntity = Convert.produtoRequestToProduto(produto);
        produtoEntity.id = id;
        produtoUseCasePort.atualizarProduto(produtoEntity);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity<Void> excluir(@PathVariable int id) {
        produtoUseCasePort.excluirProduto(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/{categoriaProduto}")
    @Override
    public ResponseEntity<List<ProdutoResponse>> consultarPorCategoria(@PathVariable("categoriaProduto") String categoriaProdutoValue){
        CategoriaProduto categoriaProduto = CategoriaProduto.fromValue(categoriaProdutoValue);
        var response = Convert.listProdutoToListProdutoResponse(produtoUseCasePort.consultarProdutos(categoriaProduto));
        return ResponseEntity.ok().body(response);
    }

}
