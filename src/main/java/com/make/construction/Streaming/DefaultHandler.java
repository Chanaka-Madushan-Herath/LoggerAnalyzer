package com.make.construction.Streaming;

import com.make.construction.databases.Emails;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class DefaultHandler extends FileHandler{
    public DefaultHandler(String filePath) {
        super(filePath);
    }

    public Emails readFile() throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new FileReader(super.filePath));
        Emails emails = new Emails();
        String readLine;
        while ((readLine = bufferedReader.readLine()) != null) {
            emails.setEmailList(readLine);
        }
        return emails;
    }

}
