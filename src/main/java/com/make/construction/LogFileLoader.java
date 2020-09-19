package com.make.construction;

import com.make.construction.Streaming.*;

import java.io.*;


public class LogFileLoader implements FileDriver {

    private final String filePath;
    private final LogStream logStream;

    public LogFileLoader(String filePath) {
        this.filePath = filePath;
        this.logStream = new LogStream(this.filePath);
    }

    @Override
    public Result readLatestLogs(String filePath) throws FileNotFoundException {
        UpdateChecker updateChecker = new UpdateChecker(this.filePath);
        try {
            if (updateChecker.check(filePath) == UpdateChecker.UPDATED) {
                this.logStream.setReadingOffset(filePath);
                return this.logStream.readLog();
            } else {
                return null;
            }
        } catch (IOException e) {
            if (e.getClass() == FileNotFoundException.class) {
                throw (FileNotFoundException)e;
            } else {
                System.err.println(OutputMessage.STREAMINGERROR.getMessage());
            }
        }
        return null;
    }

    public Result readLogsFromBeginning() throws IOException {
        return this.logStream.readLog();
    }



}
