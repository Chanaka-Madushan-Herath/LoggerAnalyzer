package com.make.construction;

import com.make.construction.Streaming.Result;
import com.make.construction.connections.EmailSender;
import com.make.construction.databases.DatabaseConnector;
import com.make.construction.databases.Emails;
import com.make.construction.databases.Retriever;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException, SQLException {

        Scanner scanner = new Scanner(System.in);
        String filePath = scanner.next();
        LogFileLoader logFileLoader = new LogFileLoader(filePath);
        Result result = logFileLoader.readLatestLogs("D:\\intelliJ JAVA WorkSpace\\LoggerAnalyzer\\src\\main\\java\\com\\make\\construction\\test.txt");
        if (result != null) {
            DatabaseConnector databaseConnector = new DatabaseConnector.Builder()
                    .build();
            databaseConnector.connect();
            Retriever retriever = new Retriever();
            retriever.retrieveMailFromDB(databaseConnector);
            Emails emails = retriever.getMailList();

            EmailSender.getInstance()
                    .setErrorMessage(result.getErrorBuffer())
                    .setEmailList(emails)
                    .setSubject(result.getSubject())
                    .sendMessage();
        } else {
            System.out.println("No changes have been made to the log file since the last analyse.");
        }
    }
}