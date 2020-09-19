package com.make.construction.Streaming;

import java.util.ArrayList;
import java.util.List;

public class Result extends ErrorBuffer implements LineHandler{

    private List<String> emailBuffer;
    private String timeStamp;
    private String subject;

    public Result() {
        this.emailBuffer = new ArrayList<>();
    }

    @Override
    public List<String> getEmailBuffer() {
        return emailBuffer;
    }

    @Override
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
