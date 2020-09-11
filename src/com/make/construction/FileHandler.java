package com.make.construction;

import java.io.BufferedReader;

public abstract class FileHandler {

    String filePath;

    public FileHandler(String filePath) {
        this.filePath = filePath;
    }
}
