package com.avalanches.adapter.driver;

import com.avalanches.adapter.driver.dto.ClienteRequest;
import com.avalanches.adapter.driver.dto.ClienteResponse;
import com.avalanches.adapter.driver.dto.ImagemRequest;
import com.avalanches.adapter.driver.dto.ProdutoRequest;
import com.avalanches.adapter.driver.dto.ProdutoResponse;
import com.avalanches.core.domain.entities.Cliente;
import com.avalanches.core.domain.entities.Imagem;
import com.avalanches.core.domain.entities.Produto;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Convert {

    public static Cliente clienteRequestToCliente(ClienteRequest request) {
        return new Cliente(request.nome(), request.cpf(), request.email());
    }

    public static ClienteResponse clienteToClienteResponse(Cliente cliente){
        return new ClienteResponse(cliente.getNome(), cliente.getCpf(), cliente.getEmail());
    }

    public static Produto produtoRequestToProduto(ProdutoRequest request) {
        return new Produto(
            request.id(),
            request.valor(),
            request.quantidade(),
            request.categoria(),
            request.nome(),
            request.descricao(),
            request.imagens() == null ? Collections.emptyList() : imagemRequestsToImagens(List.of(request.imagens()))
        );
    }

    public static List<Imagem> imagemRequestsToImagens(List<ImagemRequest> imagens) {
        if (imagens == null) {
            return Collections.emptyList(); // Return an empty list if 'imagens' is null
        } else {
            return imagens.stream()
                    .map(imagemRequest -> new Imagem(
                        imagemRequest.id(),
                        imagemRequest.nome(),
                        imagemRequest.descricao(),
                        imagemRequest.tipoConteudo(),
                        imagemRequest.tamanho(),
                        null,
                        imagemRequest.conteudo()
                    ))
                    .collect(Collectors.toList());
        }
    }

    public static List<ProdutoResponse> listProdutoToListProdutoResponse(List<Produto> listaProduto) {

        List<ProdutoResponse> listaProdutoResponse = listaProduto.stream()
                .map(produto -> new ProdutoResponse(
                        produto.id,
                        produto.valor,
                        produto.quantidade,
                        produto.categoria,
                        produto.nome,
                        produto.descricao,
                        produto.imagens)).collect(Collectors.toList());

        return listaProdutoResponse;
    }

}
