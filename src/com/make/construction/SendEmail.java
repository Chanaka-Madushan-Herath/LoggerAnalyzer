package com.make.construction;

import com.sun.mail.smtp.SMTPTransport;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;

public class SendEmail {

    public static void main(String[] args) throws Exception {

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
        t.connect("smtp.mailgun.org", "postmaster@sandbox1bcb3956d2964f0d8397fd610d0b80be.mailgun.org", "afcbf72bdbe770fcf2377cd42b4370f8-0f472795-ce7f06f5");
        t.sendMessage(msg, msg.getAllRecipients());

        System.out.println("Response: " + t.getLastServerResponse());

        t.close();
    }
}