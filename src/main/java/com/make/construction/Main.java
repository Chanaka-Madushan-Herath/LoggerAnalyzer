package com.make.construction;

import com.make.construction.Streaming.Result;
import com.make.construction.connections.EmailSender;
import com.make.construction.databases.DatabaseConnector;
import com.make.construction.databases.Emails;
import com.make.construction.databases.Retriever;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String filePath = scanner.next();
        LogFileLoader logFileLoader = new LogFileLoader(filePath);
        try {
            Result result = logFileLoader.readLatestLogs("C:\\Users\\Ovindu\\Desktop\\project2\\LoggerAnalyzer\\src\\main\\java\\com\\make\\construction\\test.txt");

            if (result != null) {
                DatabaseConnector databaseConnector = new DatabaseConnector.Builder()
                        .build();
                databaseConnector.connect();
                Retriever retriever = new Retriever();
                try {
                    retriever.retrieveMailFromDB(databaseConnector);
                } catch (SQLException throwable) {
                    throwable.printStackTrace();
                    return;
                }
                Emails emails = null;

                emails = retriever.getMailList();

                EmailSender.getInstance()
                        .setErrorMessage(result.getErrorBuffer())
                        .setEmailList(emails)
                        .setSubject(result.getSubject())
                        .sendMessage();

            } else {
                System.out.println("No changes have been made to the log file since the last analyse.");
            }
        } catch (FileNotFoundException e) {
            System.err.println("The system can't find the file specified");
        }
    }
}