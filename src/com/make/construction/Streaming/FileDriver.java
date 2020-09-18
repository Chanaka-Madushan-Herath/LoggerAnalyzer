package com.make.construction.Streaming;

import java.io.IOException;

public interface FileDriver {
    Result readLatestLogs(String filePath) throws IOException;
}
