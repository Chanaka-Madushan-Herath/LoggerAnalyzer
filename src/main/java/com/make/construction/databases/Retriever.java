package com.make.construction.databases;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Retriever {

    private ResultSet resultSet;

    public Emails getMailList() throws SQLException {

        Emails emails = new Emails();
        while(resultSet.next()){
            emails.setEmailList(resultSet.getString("email"));
        }
        return emails;

    }

    public void retrieveMailFromDB(DatabaseConnector databaseConnector) throws SQLException {

        Statement statement = databaseConnector.getConnection().createStatement();
        this.resultSet = statement.executeQuery("SELECT email from emails");

    }




}
