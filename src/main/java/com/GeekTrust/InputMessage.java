package com.GeekTrust;

public class InputMessage {
    String kingdom;
    String secretMessage;

    public InputMessage(String kingdom, String secretMessage) {
        this.kingdom = kingdom;
        this.secretMessage = secretMessage;
    }

    public String getKingdom() {
        return kingdom;
    }

    public String getSecretMessage() {
        return secretMessage;
    }
}
