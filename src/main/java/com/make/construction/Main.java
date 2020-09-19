package com.make.construction;

import com.make.construction.Streaming.DefaultHandler;
import com.make.construction.Streaming.OutputMessage;
import com.make.construction.Streaming.Result;
import com.make.construction.Streaming.SaveStream;
import com.make.construction.connections.EmailSender;
import com.make.construction.databases.DatabaseConnector;
import com.make.construction.databases.Emails;
import com.make.construction.databases.Retriever;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String filePath = scanner.next();
        LogFileLoader logFileLoader = new LogFileLoader(filePath);
        try {
            Result result = logFileLoader.readLatestLogs(SaveStream.defaultSavingPath);
            if (result != null && result.getErrorBuffer().size() > 0) {
                DatabaseConnector databaseConnector = new DatabaseConnector.Builder().build();
                Emails emails;
                if (databaseConnector.connect() == DatabaseConnector.SUCCESSFUL) {
                    Retriever retriever = new Retriever();
                    retriever.retrieveMailFromDB(databaseConnector);
                    emails = retriever.getMailList();
                } else {
                    emails = new DefaultHandler(DefaultHandler.DEFAULTMAILPATH).readFile();
                }
                EmailSender.getInstance()
                        .setErrorMessage(result.getErrorBuffer())
                        .setEmailList(emails)
                        .setSubject(result.getSubject())
                        .sendMessage();

            } else if (result != null && result.getErrorBuffer().size() == 0) {
                System.out.println(OutputMessage.NOERRORSINTHEUPDATES.getMessage());
            } else {
                System.out.println(OutputMessage.NOUPDATE.getMessage());
            }
        } catch (FileNotFoundException e) {
            System.err.println(OutputMessage.NOFILE.getMessage());
        }

    }

}