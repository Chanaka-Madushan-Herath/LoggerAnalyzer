package com.make.construction.databases;

import com.make.construction.Streaming.DefaultHandler;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Retriever {

    private ResultSet resultSet;
    private Emails emails;

    public Emails getMailList() {

        try {
            this.emails = new Emails();
            while (resultSet.next()) {
                emails.setEmailList(resultSet.getString("email"));
            }
        } catch (SQLException e) {
            return emails;
        }
        return emails;

    }

    public void retrieveMailFromDB(DatabaseConnector databaseConnector) {

        Statement statement;
        try {
            statement = databaseConnector.getConnection().createStatement();
            this.resultSet = statement.executeQuery("SELECT email from emails");
        } catch (SQLException e) {
            emails = new DefaultHandler(DefaultHandler.DEFAULTMAILPATH).readFile();
        }

    }

}
