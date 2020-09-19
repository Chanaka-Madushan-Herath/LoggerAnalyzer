package com.make.construction.databases;

import com.make.construction.Streaming.DefaultHandler;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Retriever {

    private ResultSet resultSet;

    public Emails getMailList() {

        Emails emails = new Emails();
        try {
            while (resultSet.next()) {
                emails.setEmailList(resultSet.getString("email"));
            }
        } catch (SQLException e) {
            try {
                emails = new DefaultHandler("src/main/java/com/make/construction/databases/SecondaryDatabaseForMails.txt").readFile();
            } catch (IOException ioException) {
                System.err.println("There is an error while accessing the databases");
            }
        }
        return emails;

    }

    public void retrieveMailFromDB(DatabaseConnector databaseConnector) throws SQLException {

        Statement statement = databaseConnector.getConnection().createStatement();
        this.resultSet = statement.executeQuery("SELECT email from emails");

    }




}
