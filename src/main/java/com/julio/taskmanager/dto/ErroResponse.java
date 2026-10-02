package com.julio.taskmanager.dto;

import java.util.List;

public class ErroResponse {
    private int status;
    private List<String> mensagem;

    public ErroResponse(int status, List<String> mensagem){
        this.status = status;
        this.mensagem = mensagem;
    }

    public int getStatus() {
        return status;
    }

    public List<String>  getMensagem() {
        return mensagem;
    }
}
