package com.make.construction.Streaming;

import java.io.*;

public class SaveStream extends FileHandler implements OutputFileHandler{

    public final static String defaultSavingPath = "src/main/java/com/make/construction/test.txt";

    public SaveStream(String filePath) {
        super(filePath);
    }

    @Override
    public void write(LineHandler lineHandler) throws IOException {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(super.filePath))){
            bufferedWriter.write(lineHandler.getLine());
        }
        System.out.println(OutputMessage.SUCCESS.getMessage());
    }

    @Override
    public void read(InputFileHandler inputFileHandler) throws IOException {

        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(super.filePath))) {
            String timeStamp = bufferedReader.readLine();
            if (timeStamp != null) {
                while (!timeStamp.equals(inputFileHandler.getReader().readLine())) {
                    //Reading the logfile until last read line
                }
            }

        }
    }

}
