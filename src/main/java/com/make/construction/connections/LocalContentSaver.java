package com.make.construction.connections;

import com.make.construction.Streaming.LineHandler;
import com.make.construction.Streaming.Result;
import com.make.construction.databases.Emails;

import java.io.IOException;
import java.util.Date;
import java.util.List;

public class LocalContentSaver {

    private DefaultMailSender defaultMailSender;

    public LocalContentSaver() {
        this.defaultMailSender = new DefaultMailSender("src/main/java/com/make/construction/connections/DefaultMailing.txt");

    }

    public void saveMails(Emails emails) {
        LineHandler lineHandlerForSubject = new Result();
        Date date = new Date();
        lineHandlerForSubject.setLine(date + ": The error logs may be sent to the below mails");
        try {
            defaultMailSender.write(lineHandlerForSubject);
            for (String mail : emails.getEmailList()) {
                LineHandler lineHandler = new Result();
                lineHandler.setLine(mail);
                defaultMailSender.write(lineHandler);
            }
        } catch (IOException e) {
            System.err.println("There was an error in the system while saving the local files");
        }

    }

    public void saveErrorMessages(List<String> errorBuffer) {
        try {
            for (String error: errorBuffer) {
                LineHandler lineHandler = new Result();
                lineHandler.setLine(error);
                defaultMailSender.write(lineHandler);
            }
        } catch (IOException e) {
            System.err.println("There was an error in the system while saving the local files");
        }
    }

}
