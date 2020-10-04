package com.make.construction.Streaming;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LogStream extends FileHandler implements InputFileHandler {

    private BufferedReader bufferedReader;

    public LogStream(String filePath) {
        super(filePath);
    }

    public Result readLog() throws IOException {
        String readLine;
        int i = 0;
        String lastLine = null;
        Result result = new Result();
        try {
            while ((readLine = bufferedReader.readLine()) != null) {
                if (readLine.contains("ERROR")) {
                    result.setErrorBuffer(readLine);
                    i++;
                }
                lastLine = readLine;
            }
            bufferedReader.close();
            result.setSubject("There are " + i + " error(s)");
            System.out.println("There are " + i + " error(s)");
        } finally {
            if (lastLine != null) {
                System.out.println(OutputMessage.SAVING.getMessage());
                result.setLine(lastLine);
                SaveStream saveStream = new SaveStream(SaveStream.defaultSavingPath);
                saveStream.write(result);
            }
        }
        return result;
    }

    @Override
    public void setReadingOffset(String filePath) throws IOException {
        this.bufferedReader = new BufferedReader(new FileReader(super.filePath));
        SaveStream saveStream = new SaveStream(filePath);
        saveStream.read(this);
    }

    @Override
    public BufferedReader getReader() {
        return this.bufferedReader;
    }

}
