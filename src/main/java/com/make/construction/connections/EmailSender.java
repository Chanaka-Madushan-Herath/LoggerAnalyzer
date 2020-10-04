package com.make.construction.connections;

import com.make.construction.Streaming.OutputMessage;
import com.make.construction.Streaming.Result;
import com.make.construction.databases.Emails;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.mashape.unirest.request.body.MultipartBody;

import java.util.List;

public class EmailSender {

    private static final String APIKEY = "FILL THIS APIKEY";
    private static final String DOMAIN_NAME = "FILL THIS DOMAIN NAME";
    private List<String> errorBuffer;
    private Emails emails;
    private String subject;

    public EmailSender(Result result, Emails emails) {
        this.errorBuffer = result.getErrorBuffer();
        this.emails = emails;
        this.subject = result.getSubject();
    }

    public void sendMessage() {
        for (String mail: emails.getEmailList()) {
            try {
                MultipartBody multipartBody = Unirest.post("https://api.mailgun.net/v3/" + DOMAIN_NAME + "/messages")
                        .basicAuth("api", APIKEY)
                        .field("from", "constructionProject@gmail.com")
                        .field("to", mail)
                        .field("subject", subject);
                this.setErrorMessage(multipartBody);
                HttpResponse<JsonNode> request = multipartBody.asJson();
                System.out.println(request.getStatusText());
            } catch (UnirestException e) {
                System.out.println(OutputMessage.CONNECTIONERROR.getMessage() + OutputMessage.CONNECTINGTOWRITE.getMessage());
                LocalContentSaver localContentSaver = new LocalContentSaver();
                localContentSaver.saveMails(emails);
                localContentSaver.saveErrorMessages(errorBuffer);
            }
        }
    }

    private void setErrorMessage(MultipartBody multipartBody){
        for (String error: errorBuffer) {
            multipartBody.field("text", error);
        }
    }

}