package com.make.construction;

import com.sun.mail.smtp.SMTPTransport;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;

public class SendEmail {

    public void sender(String SenderMail, String ReceiverMail, String MailSubject, String MailBody) {

        String hostname= "smtp.mailgun.org";
        String Protocol= "smtps";
        String Username= "postmaster@sandbox1bcb3956d2964f0d8397fd610d0b80be.mailgun.org";
        String password= "afcbf72bdbe770fcf2377cd42b4370f8-0f472795-ce7f06f5";
        Properties props = System.getProperties();
        props.put("mail.smtps.host", hostname);
        props.put("mail.smtps.auth", "true");

        Session session = Session.getDefaultInstance(props, null);
        Message msg = new MimeMessage(session);
        try {
            msg.setFrom(new InternetAddress(SenderMail));
        } catch (MessagingException e) {
            e.printStackTrace();
        }

        InternetAddress[] addrs = new InternetAddress[0];
        try {
            addrs = InternetAddress.parse(ReceiverMail, false);
        } catch (AddressException e) {
            e.printStackTrace();
        }
        try {
            msg.setRecipients(Message.RecipientType.TO, addrs);
        } catch (MessagingException e) {
            e.printStackTrace();
        }

        try {
            msg.setSubject(MailSubject);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        try {
            msg.setText(MailBody);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        try {
            msg.setSentDate(new Date());
        } catch (MessagingException e) {
            e.printStackTrace();
        }

        SMTPTransport t = null;
        try {
            t = (SMTPTransport) session.getTransport(Protocol);
        } catch (NoSuchProviderException e) {
            e.printStackTrace();
        }
        try {
            assert t != null;
            t.connect(hostname, Username, password);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        try {
            t.sendMessage(msg, msg.getAllRecipients());
        } catch (MessagingException e) {
            e.printStackTrace();
        }

        System.out.println("successfully.....");

        try {
            t.close();
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}