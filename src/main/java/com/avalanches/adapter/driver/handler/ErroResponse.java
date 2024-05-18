package com.avalanches.adapter.driver.handler;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ErroResponse {

    private int status;
    private String mensagem;
    private String timestamp;

    public ErroResponse(int status, String mensagem, LocalDateTime timestamp) {
        this.status = status;
        this.mensagem = mensagem;
        this.timestamp = timestamp.format(DateTimeFormatter.ISO_DATE_TIME);
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getmensagem() {
        return mensagem;
    }

    public void setmensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

}
