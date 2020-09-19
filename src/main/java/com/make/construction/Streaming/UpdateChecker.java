package com.make.construction.Streaming;

import java.io.IOException;

public class UpdateChecker extends FileHandler{

    public static final int UPDATED = 0;
    public static final int NOTUPDATED = 1;

    public UpdateChecker(String filePath) {
        super(filePath);
    }

    public int check(String filePath) throws IOException {
        LogStream logStream = new LogStream(super.filePath);
        logStream.setReadingOffset(filePath);
        if (logStream.getReader().readLine() != null){
            logStream.getReader().close();
            return UPDATED;
        } else {
            logStream.getReader().close();
            return NOTUPDATED;
        }
    }


}
