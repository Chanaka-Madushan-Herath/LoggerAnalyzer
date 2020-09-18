package com.make.construction;

import com.make.construction.Streaming.FileDriver;
import com.make.construction.Streaming.LogStream;
import com.make.construction.Streaming.Result;

import java.io.*;


public class LogFileLoader implements FileDriver {

    private String filePath;
    LogStream logStream;

    public LogFileLoader(String filePath) {
        this.filePath = filePath;
        this.logStream = new LogStream(this.filePath);
    }

    @Override
    public Result readLatestLogs(String filePath) throws IOException {
        this.logStream.setReadingOffset(filePath);
        return this.logStream.readLog();
    }

    public Result readLogsFromBeginning() throws IOException {
        return this.logStream.readLog();
    }



}
