package com.make.construction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseConnection {
    public void getEmails(){
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/emailsdb?useTimezone=true&serverTimezone=UTC","root","");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * from emails");

            while(rs.next()){
                System.out.println(rs.getInt(1)+" "+ rs.getString(2));
            }
            con.close();

        }catch (Exception e){
            System.out.println(e);
        }
    }
}
