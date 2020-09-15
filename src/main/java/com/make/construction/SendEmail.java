package com.make.construction;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import kong.unirest.UnirestException;

public class SendEmail {

    public static JsonNode sendSimpleMessage(String sender,String receiver, String subject, String body) throws UnirestException {

        String url="https://api.mailgun.net/v3/sandbox1bcb3956d2964f0d8397fd610d0b80be.mailgun.org";
        String apikey="92b1910a8359c4b965f652f882ea5e18-0f472795-49561bc3";

        HttpResponse<JsonNode> request = Unirest.post( url+ "/messages")
                .basicAuth("api",apikey )
                .field("from", sender)
                .field("to", receiver)
                .field("subject", subject)
                .field("text", body)
                .asJson();
        System.out.println("Successfully....");
        return request.getBody();

    }
}

