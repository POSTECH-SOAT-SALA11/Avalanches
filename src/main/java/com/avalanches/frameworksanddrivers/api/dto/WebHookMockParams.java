package com.avalanches.frameworksanddrivers.api.dto;

import okhttp3.OkHttpClient;

public class WebHookMockParams {
    public String BaseUrl = "http://sistema-pagamentos-mock-service:5001/pagamento/";
    public OkHttpClient httpClient = new OkHttpClient();
}
