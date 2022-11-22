package br.com.zago.linguagensapi.model;

public class ApiMessage {
    
    private String message;

    public ApiMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
