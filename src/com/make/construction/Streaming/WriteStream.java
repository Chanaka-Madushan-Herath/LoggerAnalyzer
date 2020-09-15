package com.make.construction.Streaming;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class WriteStream extends FileHandler implements OutputFileHandler{
    public WriteStream(String filePath) {
        super(filePath);
    }

    @Override
    public void write(LineHandler lineHandler) throws IOException {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(super.filePath))){
            bufferedWriter.write(lineHandler.getLine());
        }
    }
}
