package com.make.construction.Streaming;

import java.util.ArrayList;
import java.util.List;

public class Result extends ErrorBuffer implements LineHandler{

    private List<String> errorBuffer;
    private String timeStamp;
    private String subject;

    public Result() {
        this.errorBuffer = new ArrayList<>();
    }

    @Override
    public List<String> getErrorBuffer() {
        return errorBuffer;
    }

    @Override
    public void setErrorBuffer(String message) {
        this.errorBuffer.add(message);
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
