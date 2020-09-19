package com.make.construction;

import com.make.construction.Streaming.FileDriver;
import com.make.construction.Streaming.LogStream;
import com.make.construction.Streaming.Result;
import com.make.construction.Streaming.UpdateChecker;

import java.io.*;


public class LogFileLoader implements FileDriver {

    private final String filePath;
    private final LogStream logStream;
    private static final int UPDATED = 0;
    private static final int NOTUPDATED = 1;

    public LogFileLoader(String filePath) {
        this.filePath = filePath;
        this.logStream = new LogStream(this.filePath);
    }

    @Override
    public Result readLatestLogs(String filePath) throws FileNotFoundException {
        UpdateChecker updateChecker = new UpdateChecker(this.filePath);
        try {
            if (updateChecker.check(filePath) == UPDATED) {
                this.logStream.setReadingOffset(filePath);
                return this.logStream.readLog();
            } else {
                return null;
            }
        } catch (IOException e) {
            if (e.getClass() == FileNotFoundException.class) {
                throw (FileNotFoundException)e;
            } else {
                System.err.println("There was an error reading the files");
            }
        }
        return null;
    }

    public Result readLogsFromBeginning() throws IOException {
        return this.logStream.readLog();
    }



}
