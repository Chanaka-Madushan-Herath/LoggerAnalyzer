package com.make.construction.databases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector {

    private String serverName;
    private String userName;
    private String password;
    private Connection connection;

    private DatabaseConnector(Builder builder) {
        this.password = builder.password;
        this.userName = builder.userName;
        this.serverName = builder.serverName;
    }

    public static class Builder {
        private static String USER_NAME = "root";
        private static String PASSWORD = "sesame";
        private static String SERVER_NAME = "jdbc:mysql://localhost:3306/email_list";
        private static String PORT = "3306";
        private static String DATABASE = "email_list";
        private String serverName;
        private String userName;
        private String password;
        private String port;
        private String database;

        public Builder() {
            this.serverName = SERVER_NAME;
            this.password = PASSWORD;
            this.userName = USER_NAME;
        }

        public Builder withPassword(String password) {
            this.password = password;
            return this;
        }

        public Builder userName(String userName) {
            this.userName = userName;
            return this;
        }

        public DatabaseConnector build() {
            return new DatabaseConnector(this);
        }

    }

    public int connect() {

        try {
            this.connection = DriverManager.getConnection(this.serverName, this.userName, this.password);
            System.out.println("Connection Successful");
        }catch (Exception e) {
            System.out.println(e);
            return 1;

        }
        return 0;
    }

    public Connection getConnection() {
        return connection;
    }
}
