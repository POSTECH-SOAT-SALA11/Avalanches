package com.avalanches.interfaceadapters.gateways;

import com.avalanches.enterprisebusinessrules.entities.Pagamento;
import com.avalanches.frameworksanddrivers.api.dto.WebHookMockParams;
import com.avalanches.interfaceadapters.gateways.interfaces.PagamentoGatewayInterface;
import jakarta.inject.Inject;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.springframework.jdbc.core.JdbcOperations;

import java.io.IOException;

public class PagamentoGateway implements PagamentoGatewayInterface {

    private final JdbcOperations jdbcOperations;
    private final WebHookMockParams webHookMockParams;

    public PagamentoGateway(JdbcOperations jdbcOperations,
                            WebHookMockParams webHookMockParams) {
        this.jdbcOperations = jdbcOperations;
        this.webHookMockParams = webHookMockParams;
    }

    @Override
    public void cadastrar(Pagamento pagamento) {
        jdbcOperations.update("INSERT INTO pagamento (id_pedido, status) VALUES (?,?)",
                pagamento.getIdPedido(),
                pagamento.getStatusPagamento().name()); // Converte o enum para string
    }

    @Override
    public Boolean efetuarPagamento(Integer idPedido) {
        String url = webHookMockParams.BaseUrl + idPedido;
        MediaType JSON = MediaType.get("application/json; charset=utf-8");

        RequestBody body = RequestBody.create("", JSON);

        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();

        try (Response response = webHookMockParams.httpClient.newCall(request).execute()) {
            return response.isSuccessful();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }


}
