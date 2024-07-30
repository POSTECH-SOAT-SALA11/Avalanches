package com.avalanches.interfaceadapters.gateways;

import com.avalanches.interfaceadapters.gateways.interfaces.PagamentoClientInterface;
import okhttp3.*;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class PagamentoClient implements PagamentoClientInterface {

    private static final String BASE_URL = "http://localhost:5001/pagamento/";
    private final OkHttpClient client;

    public PagamentoClient() {
        this.client = new OkHttpClient();
    }


    @Override
    public Boolean efetuarPagamento(Integer idPedido) {
        String url = BASE_URL + idPedido;
        MediaType JSON = MediaType.get("application/json; charset=utf-8");

        RequestBody body = RequestBody.create("", JSON);

        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();

        try (Response response = client.newCall(request).execute()) {
            return response.isSuccessful();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
