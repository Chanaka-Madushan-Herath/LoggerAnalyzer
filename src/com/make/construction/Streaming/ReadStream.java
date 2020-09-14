package com.make.construction.Streaming;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReadStream extends FileHandler implements InputFileHandler {

    private ArrayList<String> errorList;
    private BufferedReader bufferedReader;

    public ReadStream(String filePath) {
        super(filePath);
    }

    @Override
    public void read() throws IOException {
        this.bufferedReader = new BufferedReader(new FileReader(super.filePath));
        String readLine;
        String lastLine = null;
        Result result = new Result();
        errorList = new ArrayList<>();
        try {
            while ((readLine = this.bufferedReader.readLine()) != null) {
                if (readLine.contains("ERROR")) {
                    this.errorList.add(readLine);
                }
                lastLine = readLine;
            }
        }finally {
            result.setLastLine(lastLine);
        }

    }



}
