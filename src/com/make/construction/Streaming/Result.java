package com.make.construction.Streaming;

import java.util.ArrayList;
import java.util.List;

public class Result implements LineHandler{

    private List<String> emailBuffer;
    private String timeStamp;
    private String subject;

    public Result() {
        this.emailBuffer = new ArrayList<>();
    }

    public List<String> getEmailBuffer() {
        return emailBuffer;
    }

    public void setEmailBuffer(String message) {
        this.emailBuffer.add(message);
    }


    @Override
    public void setLine(String message) {
        this.timeStamp = message;
    }

    @Override
    public String getLine() {
        return this.timeStamp;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

}
