package com.avalanches.adapter.driver.controller;

import com.avalanches.adapter.driver.dto.ProdutoRequest;
import com.avalanches.adapter.driver.dto.ProdutoResponse;
import com.avalanches.core.domain.entities.CategoriaProduto;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface ProdutoControllerDoc {

     @Operation(summary = "Cadastro de produto",
                description = "Endpoint utilizado para realizar o cadastro do produto, o conteúdo das imagens deve ser enviado via bytes.")
     ResponseEntity<Void> cadastrar(@Valid @RequestBody ProdutoRequest produto);

     @Operation(summary = "Atualização de produto",
             description = "Endpoint utilizado para realizar a atualização do produto, o conteúdo das imagens deve ser enviado via bytes," +
                           " as imagens sem id serão criadas, as com id serão atualizadas, e as imagens não enviadas serão excluídas.")
     ResponseEntity<Void> atualizar(@PathVariable int id, @Valid @RequestBody ProdutoRequest produto);

     @Operation(summary = "Exclusão de produto",
             description = "Endpoint utilizado para realizar a exclusão do produto.")
     ResponseEntity<Void> excluir(@PathVariable int id);

     @Operation(summary = "Consulta de produtos por categoria",
             description = "Endpoint utilizado para realizar a consulta do produto via categoria.")
     ResponseEntity<List<ProdutoResponse>> consultarPorCategoria(@PathVariable("categoriaProduto") CategoriaProduto categoriaProdutoValue);

}
