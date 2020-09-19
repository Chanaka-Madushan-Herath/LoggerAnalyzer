package com.make.construction.databases;

import com.make.construction.Streaming.DefaultHandler;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Retriever {

    private ResultSet resultSet;

    public Emails getMailList() throws SQLException, IOException {

        Emails emails = new Emails();
        if (resultSet != null) {
            while (resultSet.next()) {
                emails.setEmailList(resultSet.getString("email"));
            }
        } else {
            emails = new DefaultHandler("src/main/java/com/make/construction/databases/SecondaryDatabaseForMails.txt").readFile();
        }
        return emails;

    }

    public void retrieveMailFromDB(DatabaseConnector databaseConnector) throws SQLException {

        Statement statement = databaseConnector.getConnection().createStatement();
        this.resultSet = statement.executeQuery("SELECT email from emails");

    }




}
