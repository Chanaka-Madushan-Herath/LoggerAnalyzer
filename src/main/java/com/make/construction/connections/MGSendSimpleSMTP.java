package com.make.construction.connections;

import java.io.*;
import java.net.InetAddress;
import java.util.Properties;
import java.util.Date;
import javax.mail.*;
import javax.mail.internet.*;
import com.sun.mail.smtp.*;

public class MGSendSimpleSMTP {

    public void sendMail() throws Exception {

        Properties props = System.getProperties();
        props.put("mail.smtps.host", "smtp.mailgun.org");
        props.put("mail.smtps.auth", "true");

        Session session = Session.getInstance(props, null);
        Message msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress("upsidedowndragon9999@gmail.com"));

        InternetAddress[] addrs = InternetAddress.parse("neminda99prabhashwara@gmail.com", false);
        msg.setRecipients(Message.RecipientType.TO, addrs);

        msg.setSubject("Hello");
        msg.setText("Testing some Mailgun awesomness");
        msg.setSentDate(new Date());

        SMTPTransport t =
                (SMTPTransport) session.getTransport("smtps");
        t.connect("smtp.mailgun.org", "postmaster@sandbox7fd88cb76ec34d89bcc46d3c161fd7f0.mailgun.org", "dc88283171af9b3c9faf7cb0ec036f7d-d5e69b0b-67e2852f");
        t.sendMessage(msg, msg.getAllRecipients());

        System.out.println("Response: " + t.getLastServerResponse());

        t.close();
    }

}