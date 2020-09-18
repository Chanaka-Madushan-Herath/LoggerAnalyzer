package com.make.construction.databases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseConnection {


    public void getEmails(){
        try {

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/email_list","root","sesame");
            if (con != null)
                System.out.println("Connection Successful");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT email from emails");

            while(rs.next()){
                System.out.println(rs.getString("email"));
            }
            con.close();

        } catch (Exception e) {
            System.out.println(e.getCause());
        }
    }

    public static void main(String[] args) {
        DatabaseConnection databaseConnection = new DatabaseConnection();
        databaseConnection.getEmails();
    }


}
