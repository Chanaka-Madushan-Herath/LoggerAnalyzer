package com.make.construction.connections;


import com.make.construction.Streaming.ErrorBuffer;
import com.make.construction.Streaming.Result;
import com.make.construction.databases.Emails;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.mashape.unirest.request.HttpRequestWithBody;
import com.mashape.unirest.request.body.MultipartBody;
import com.sun.org.apache.xml.internal.security.keys.content.MgmtData;

import java.util.List;


public class MGSample {

    private static String APIKEY = "4bc64febb36bf5a25d93151bf5da4124-d5e69b0b-399c5521";
    private static String DOMAIN_NAME = "sandbox7fd88cb76ec34d89bcc46d3c161fd7f0.mailgun.org";
    private static MultipartBody multipartBody;
    private static MGSample mgSample;
    HttpResponse<JsonNode> request;

    // ...

    public static MGSample getInstance() {




        if (multipartBody == null) {
            multipartBody = Unirest.post("https://api.mailgun.net/v3/" + DOMAIN_NAME + "/messages")
                    .basicAuth("api", APIKEY)
                    .field("from", "Excited User <upsidedowndragon9999@gmail.com>")
                    .field("subject", "ErrorLogs");
        }


        mgSample = new MGSample();

        return mgSample;
    }


    public JsonNode sendSimpleMessage() throws UnirestException {

        HttpResponse<JsonNode> request = multipartBody.asJson();
        System.out.println(request.getStatusText());
        return request.getBody();
    }

    public MGSample setEmailList(Emails emails){

        for (String mail: emails.getEmailList()){
            multipartBody.field("to", mail);
        }

        return mgSample;
    }

    public MGSample setErrorMessage(List<String> errorBuffer){

        for (String message: errorBuffer) {
            multipartBody.field("text", message);
        }

        return mgSample;

    }

    public static void main(String[] args) throws UnirestException {
        MGSample mgSample = new MGSample();
        System.out.println(mgSample.sendSimpleMessage());
    }

}

