package com.make.construction.Streaming;

import java.io.BufferedReader;
import java.io.IOException;

public interface InputFileHandler {
    void setReadingOffset(String filePath) throws IOException;
    BufferedReader getReader();
}
