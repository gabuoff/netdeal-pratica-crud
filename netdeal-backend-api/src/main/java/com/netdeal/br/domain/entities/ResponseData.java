package com.netdeal.br.domain.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseData {
    private String message;
    private Object data;

    // Construtores
    public ResponseData() {}

    public ResponseData(String message) {
        this.message = message;
    }

    public ResponseData(String message, Object data) {
        this.message = message;
        this.data = data;
    }

  
    @Override
    public String toString() {
        return "ResponseData{" +
                "message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
