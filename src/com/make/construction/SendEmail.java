package com.make.construction;
import java.io.*;
import java.net.InetAddress;
import java.util.Properties;
import java.util.Date;
import javax.mail.*;
import javax.mail.internet.*;
import com.sun.mail.smtp.*;

public class SendEmail {

    public static void EmailSender(String args[]) throws Exception {

        Properties props = System.getProperties();
        props.put("mail.smtps.host", "smtp.mailgun.org");
        props.put("mail.smtps.auth", "true");

        Session session = Session.getDefaultInstance(props, null);
        Message msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress("chanaka.herath.1998@gmail.com"));

        InternetAddress[] addrs = InternetAddress.parse("cmadushan1998@gmail.com", false);
        msg.setRecipients(Message.RecipientType.TO, addrs);

        msg.setSubject("Hello");
        msg.setText("Testing some Mailgun awesomness");
        msg.setSentDate(new Date());

        SMTPTransport t =
                (SMTPTransport) session.getTransport("smtps");
        t.connect("smtp.mailgun.org", "postmaster@sandbox1bcb3956d2964f0d8397fd610d0b80be.mailgun.org", "67e6c96e42ef08155c9886f23dc5fbe9-0f472795-2ad3b498");
        t.sendMessage(msg, msg.getAllRecipients());

        System.out.println("Response: " + t.getLastServerResponse());

        t.close();
    }
}
