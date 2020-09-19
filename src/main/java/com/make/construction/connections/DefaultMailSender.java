package com.make.construction.connections;

import com.make.construction.Streaming.*;

import java.io.*;

public class DefaultMailSender extends FileHandler implements OutputFileHandler {

    public static final String DEFAULTMAILSAVINGPATH = "D:\\intelliJ JAVA WorkSpace\\LoggerAnalyzer\\src\\main\\java\\com\\make\\construction\\connections\\DefaultMailing.txt";

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
