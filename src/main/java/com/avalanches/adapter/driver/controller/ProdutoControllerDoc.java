package com.avalanches.adapter.driver.controller;

import com.avalanches.adapter.driver.dto.ClienteRequest;
import com.avalanches.adapter.driver.dto.ClienteResponse;
import com.avalanches.adapter.driver.dto.ProdutoRequest;
import com.avalanches.adapter.driver.dto.ProdutoResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface ProdutoControllerDoc {

     @Operation(summary = "Cadastro do produto",
                description = "Endpoint utilizado para realizar o cadastro do produto, o conteúdo das imagens deve ser enviado via bytes.")
     ResponseEntity<Void> create(@Valid @RequestBody ProdutoRequest produto);

     @Operation(summary = "Atualização do produto",
             description = "Endpoint utilizado para realizar a atualização do produto, o conteúdo das imagens deve ser enviado via bytes," +
                           " as imagens sem id serão criadas, as com id serão atualizadas, e as imagens não enviadas serão excluídas.")
     ResponseEntity<Void> update(@PathVariable int id, @Valid @RequestBody ProdutoRequest produto);

     @Operation(summary = "Exclusão do produto",
             description = "Endpoint utilizado para realizar a exclusão do produto.")
     ResponseEntity<Void> delete(@PathVariable int id);

     @Operation(summary = "Consulta de produtos por categoria",
             description = "Endpoint utilizado para realizar a consulta do produto via categoria.")
     ResponseEntity<List<ProdutoResponse>> get(@PathVariable("categoriaProduto") String categoriaProdutoValue);

}
