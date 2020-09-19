package com.make.construction.Streaming;

public enum OutputMessage {

    SUCCESS("Done"),
    CONNECTIONERROR("There was an error connecting to the internet."),
    DATABASEERROR("There was an error connecting to the database."),
    CONNECTINGTOGET("Connecting to the local file to get mails..."),
    CONNECTINGTOWRITE("Connecting to the local file to write errors..."),
    SAVING("Saving the file for last read point..."),
    STREAMINGERROR("There was an error in the system while saving the local files"),
    NOUPDATE("No changes have been made to the log file since the last analyse."),
    NOFILE("The system can't find the file specified"),
    DATABASECONNECTIONSUCCESS("Database Connection Successful");

    private String message;

    private OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}