package com.make.construction.Streaming;

import java.util.List;

public abstract class ErrorBuffer {
    public abstract List<String> getErrorBuffer();
    public abstract void setErrorBuffer(String message);
}
