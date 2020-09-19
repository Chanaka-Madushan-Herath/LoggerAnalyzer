package com.make.construction.Streaming;

import com.make.construction.databases.Emails;

import java.io.*;

public class DefaultHandler extends FileHandler{

    public static final String DEFAULTMAILPATH = "src/main/java/com/make/construction/databases/SecondaryDatabaseForMails.txt";
    public DefaultHandler(String filePath) {
        super(filePath);
    }

    public Emails readFile() {

        Emails emails = null;
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(super.filePath))) {
            emails = new Emails();
            String readLine;
            while ((readLine = bufferedReader.readLine()) != null) {
                emails.setEmailList(readLine);
            }
            System.out.println(OutputMessage.SUCCESS.getMessage());
        } catch (IOException e) {
            System.err.println(OutputMessage.STREAMINGERROR.getMessage());
        }
        return emails;
    }



}
