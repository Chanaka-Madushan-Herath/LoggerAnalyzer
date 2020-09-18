package com.make.construction;

import com.make.construction.Streaming.Result;
import com.make.construction.connections.MGSample;
import com.make.construction.databases.DatabaseConnector;
import com.make.construction.databases.Emails;
import com.make.construction.databases.Retriever;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException, SQLException, UnirestException {

        Scanner scanner = new Scanner(System.in);
        String filePath = scanner.next();
        LogFileLoader logFileLoader = new LogFileLoader(filePath);

        System.out.println("FFF");
        DatabaseConnector databaseConnector = new DatabaseConnector.Builder()
                .build();
        System.out.println("DDD");
        databaseConnector.connect();
        Retriever retriever = new Retriever();
        retriever.retrieveMailFromDB(databaseConnector);
        Emails mailList = retriever.getMailList();

        Result result = logFileLoader.readLatestLogs("D:\\intelliJ JAVA WorkSpace\\LoggerAnalyzer\\src\\main\\java\\com\\make\\construction\\test.txt");
        MGSample.getInstance()
                .setErrorMessage(result.getEmailBuffer())
                .setEmailList(mailList).sendSimpleMessage();
        //BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
        //BufferedReader bufferedReader1 = new BufferedReader(new FileReader("D:\\intelliJ JAVA WorkSpace\\LoggerAnalyzer\\src\\main\\java\\com\\make\\construction\\test.txt"));

    }
}