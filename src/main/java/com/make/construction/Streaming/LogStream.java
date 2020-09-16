package com.make.construction.Streaming;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class LogStream extends FileHandler implements InputFileHandler {

    private BufferedReader bufferedReader;

    public LogStream(String filePath) {
        super(filePath);
    }

    public Result readLog() throws IOException {
        String readLine;
        String lastLine = null;
        Result result = new Result();
        try {
            while ((readLine = bufferedReader.readLine()) != null) {
                if (readLine.contains("ERROR")) {
                    result.setEmailBuffer(readLine);
                }
                lastLine = readLine;
            }
        } finally {
            result.setLine(lastLine);
        }
        return result;
    }

    @Override
    public void setReadingOffset(String filePath) throws IOException{
        this.bufferedReader= new BufferedReader(new FileReader(super.filePath));
        SaveStream saveStream = new SaveStream(filePath);
        saveStream.read(this);
    }

    @Override
    public BufferedReader getReader() {
        return this.bufferedReader;
    }


}
