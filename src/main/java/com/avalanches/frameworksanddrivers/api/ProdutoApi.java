package com.avalanches.frameworksanddrivers.api;

import com.avalanches.frameworksanddrivers.api.dto.ProdutoResponse;
import com.avalanches.frameworksanddrivers.api.dto.ProdutoRequest;
import com.avalanches.enterprisebusinessrules.entities.CategoriaProduto;
import com.avalanches.enterprisebusinessrules.entities.Produto;
import com.avalanches.frameworksanddrivers.api.interfaces.ProdutoApiInterface;
import com.avalanches.interfaceadapters.controllers.ProdutoController;
import com.avalanches.interfaceadapters.controllers.interfaces.ProdutoControllerInterface;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/avalanches/v1/produto")
@Validated
public class ProdutoApi implements ProdutoApiInterface {

    @Inject
    private JdbcOperations jdbcOperations;

    @PostMapping
    @Override
    public ResponseEntity<Void> cadastrar(@Valid @RequestBody ProdutoRequest produto) {
        ProdutoControllerInterface produtoController = new ProdutoController();
        produtoController.cadastrarProduto(Convert.produtoRequestToProduto(produto), jdbcOperations);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    @Override
    public ResponseEntity<Void> atualizar(@PathVariable int id, @Valid @RequestBody ProdutoRequest produto) {
        ProdutoControllerInterface produtoController = new ProdutoController();
        Produto produtoEntity = Convert.produtoRequestToProduto(produto);
        produtoEntity.id = id;
        produtoController.atualizarProduto(produtoEntity, jdbcOperations);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity<Void> excluir(@PathVariable int id) {
        ProdutoControllerInterface produtoController = new ProdutoController();
        produtoController.excluirProduto(id, jdbcOperations);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/{categoriaProduto}")
    @Override
    public ResponseEntity<List<ProdutoResponse>> consultarPorCategoria(@PathVariable("categoriaProduto") CategoriaProduto categoriaProduto){
        ProdutoControllerInterface produtoController = new ProdutoController();
        var response = Convert.listProdutoToListProdutoResponse(produtoController.consultarProdutos(categoriaProduto, jdbcOperations));
        return ResponseEntity.ok().body(response);
    }


}
