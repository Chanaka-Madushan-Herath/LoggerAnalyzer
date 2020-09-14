package com.make.construction.Streaming;

import java.util.ArrayList;
import java.util.List;

public class Result {

    private List<String> list;
    private String lastLine;

    public Result() {
        this.list = new ArrayList<>();
    }

    public String getLastLine() {
        return lastLine;
    }

    public void setLastLine(String lastLine) {
        this.lastLine = lastLine;
    }
}
