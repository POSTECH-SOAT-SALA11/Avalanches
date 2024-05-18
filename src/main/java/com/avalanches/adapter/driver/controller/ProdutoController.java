package com.avalanches.adapter.driver.controller;

import com.avalanches.adapter.driver.Convert;
import com.avalanches.adapter.driver.dto.CreateProdutoRequest;
import com.avalanches.core.application.usecases.ProdutoUseCasePort;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/avalanches/v1")
@Validated
public class ProdutoController {

    @Autowired
    private ProdutoUseCasePort produtoUseCasePort;

    @PostMapping("/produto")
    public ResponseEntity<Void> create(@Valid  @RequestBody CreateProdutoRequest produto) {
        produtoUseCasePort.insertProduto(Convert.createProdutoRequestToProduto(produto));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

//   @PutMapping("{id}")
//   public ResponseEntity<Void> update(@PathVariable("id") int id, @Valid  @RequestBody UpdateProdutoRequest produto) {
//       servicePort.insertCustomer(Convert.updateProdutoRequestToProduto(produto));
//       return ResponseEntity.status(HttpStatus.OK).build();
//   }

}
