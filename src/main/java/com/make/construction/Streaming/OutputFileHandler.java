package com.make.construction.Streaming;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface OutputFileHandler {

    void write(LineHandler lineHandler) throws IOException;
    void read(InputFileHandler inputFileHandler) throws IOException;

}
