package com.make.construction.connections;

import com.make.construction.Streaming.LineHandler;
import com.make.construction.Streaming.OutputMessage;
import com.make.construction.Streaming.Result;
import com.make.construction.databases.Emails;

import java.io.IOException;
import java.util.Date;
import java.util.List;

public class LocalContentSaver {

    private DefaultMailSender defaultMailSender;

    public LocalContentSaver() {
        this.defaultMailSender = new DefaultMailSender(DefaultMailSender.DEFAULTMAILSAVINGPATH);
    }

    public void saveMails(Emails emails) {
        LineHandler lineHandlerForSubject = new Result();
        Date date = new Date();
        lineHandlerForSubject.setLine("\n" + date + "\nThe error logs may be sent to the below mails:");
        try {
            defaultMailSender.write(lineHandlerForSubject);
            for (String mail : emails.getEmailList()) {
                LineHandler lineHandler = new Result();
                lineHandler.setLine(mail);
                defaultMailSender.write(lineHandler);
            }
            lineHandlerForSubject.setLine("");
            defaultMailSender.write(lineHandlerForSubject);
        } catch (IOException e) {
            System.err.println(OutputMessage.STREAMINGERROR.getMessage());
        }
    }

    public void saveErrorMessages(List<String> errorBuffer) {
        try {
            for (String error: errorBuffer) {
                LineHandler lineHandler = new Result();
                lineHandler.setLine(error);
                defaultMailSender.write(lineHandler);
            }
            System.out.println(OutputMessage.SUCCESS.getMessage());
        } catch (IOException e) {
            System.err.println(OutputMessage.STREAMINGERROR.getMessage());
        }
    }

}
