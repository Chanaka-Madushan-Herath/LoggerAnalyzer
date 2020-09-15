package com.make.construction.Streaming;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadStream extends FileHandler implements InputFileHandler {

    public ReadStream(String filePath) {
        super(filePath);
    }

    @Override
    public Result read() throws IOException {
        String readLine;
        String lastLine = null;
        Result result = new Result();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(super.filePath))) {
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

}
