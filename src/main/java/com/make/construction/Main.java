package com.make.construction;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import kong.unirest.UnirestException;

public class Main {
    public static void main(String[] args) {
        sendMail();
    }
    public static void sendMail(){
        JsonNode jsonNode=sendSimpleMessage();
        System.out.println(jsonNode.toString());
    }

    public static JsonNode sendSimpleMessage() throws UnirestException {

        HttpResponse<JsonNode> request = Unirest.post("https://api.mailgun.net/v3/sandbox1bcb3956d2964f0d8397fd610d0b80be.mailgun.org" + "/messages")
                .basicAuth("api", "92b1910a8359c4b965f652f882ea5e18-0f472795-49561bc3")
                .field("from", "jeewanthalahiru1111@gmail.com")
                .field("to", "chanaka.herath.1998@gmail.com")
                .field("subject", "hello")
                .field("text", "testing")
                .asJson();

        return request.getBody();
    }

}
