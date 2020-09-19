package com.make.construction.connections;

import com.make.construction.Streaming.FileHandler;
import com.make.construction.Streaming.InputFileHandler;
import com.make.construction.Streaming.LineHandler;
import com.make.construction.Streaming.OutputFileHandler;

import java.io.*;

public class DefaultMailSender extends FileHandler implements OutputFileHandler {


    public DefaultMailSender(String filePath) {
        super(filePath);
    }

    @Override
    public void write(LineHandler lineHandler) throws IOException {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(super.filePath, true))){
            bufferedWriter.write(lineHandler.getLine());
            bufferedWriter.newLine();
        }
    }

    @Override
    public void read(InputFileHandler inputFileHandler) throws IOException {

    }
}
