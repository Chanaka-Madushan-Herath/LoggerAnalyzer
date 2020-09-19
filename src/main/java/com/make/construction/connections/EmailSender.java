package com.make.construction.connections;


import com.make.construction.Streaming.LineHandler;
import com.make.construction.Streaming.Result;
import com.make.construction.databases.Emails;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.mashape.unirest.request.body.MultipartBody;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class EmailSender {

    private static String APIKEY = "4bc64febb36bf5a25d93151bf5da4124-d5e69b0b-399c5521";
    private static String DOMAIN_NAME = "sandbox7fd88cb76ec34d89bcc46d3c161fd7f0.mailgun.org";
    private static MultipartBody multipartBody;
    private static EmailSender emailSender;
    private static List<String> errorBuffer;
    private static Emails emails;

    public static EmailSender getInstance() {

        if (multipartBody == null) {
            multipartBody = Unirest.post("https://api.mailgun.net/v3/" + DOMAIN_NAME + "/messages")
                    .basicAuth("api", APIKEY)
                    .field("from", "upsidedowndragon9999@gmail.com");
        }
        if (emailSender == null) {
            emailSender = new EmailSender();
        }
        return emailSender;
    }


    public void sendMessage() throws IOException {

        try {
            HttpResponse<JsonNode> request = multipartBody.asJson();
            System.out.println(request.getStatusText());
        } catch (UnirestException e) {
            LocalContentSaver localContentSaver = new LocalContentSaver();
            localContentSaver.saveMails(emails);
            localContentSaver.saveErrorMessages(errorBuffer);
        }
    }

    public EmailSender setSubject(String subject) {
        multipartBody.field("subject", subject);
        return emailSender;
    }

    public EmailSender setEmailList(Emails emails){

        EmailSender.emails = emails;
        for (String mail: emails.getEmailList()){
            multipartBody.field("to", mail);
        }
        return emailSender;
    }

    public EmailSender setErrorMessage(List<String> errorBuffer){
        EmailSender.errorBuffer = errorBuffer;
        for (String message: errorBuffer) {
            multipartBody.field("text", message);
        }
        return emailSender;
    }

}

