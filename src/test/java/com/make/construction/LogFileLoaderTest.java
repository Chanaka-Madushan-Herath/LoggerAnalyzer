package com.make.construction;

import org.junit.jupiter.api.Test;
import com.make.construction.Streaming.UpdateChecker;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class LogFileLoaderTest {
    @Test
    public void check_update_checker_working_or_not() throws IOException {
        UpdateChecker updateChecker = new UpdateChecker("src\\main\\java\\com\\make\\construction\\test.txt");

        assertEquals(1, updateChecker.check("src\\main\\java\\com\\make\\construction\\test.txt"));

    }
}