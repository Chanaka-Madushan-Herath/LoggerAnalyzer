package com.make.construction.Streaming;

import java.io.BufferedReader;

public abstract class FileHandler {

    protected String filePath;

    public FileHandler(String filePath) {

        this.filePath = filePath;
    }
}
