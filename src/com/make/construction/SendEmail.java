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

    public void sender(){

        Properties props = System.getProperties();
        props.put("mail.smtps.host", "smtp.mailgun.org");
        props.put("mail.smtps.auth", "true");

        Session session = Session.getDefaultInstance(props, null);
        Message msg = new MimeMessage(session);
        try {
            msg.setFrom(new InternetAddress("chanaka.herath.1998@gmail.com"));
        } catch (MessagingException e) {
            e.printStackTrace();
        }

        InternetAddress[] addrs = new InternetAddress[0];
        try {
            addrs = InternetAddress.parse("cmadushan1998@gmail.com", false);
        } catch (AddressException e) {
            e.printStackTrace();
        }
        try {
            msg.setRecipients(Message.RecipientType.TO, addrs);
        } catch (MessagingException e) {
            e.printStackTrace();
        }

        try {
            msg.setSubject("Hello");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        try {
            msg.setText("Testing some Mailgun awesomness");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        try {
            msg.setSentDate(new Date());
        } catch (MessagingException e) {
            e.printStackTrace();
        }

        SMTPTransport t =
                null;
        try {
            t = (SMTPTransport) session.getTransport("smtps");
        } catch (NoSuchProviderException e) {
            e.printStackTrace();
        }
        try {
            t.connect("smtp.mailgun.org", "postmaster@sandbox1bcb3956d2964f0d8397fd610d0b80be.mailgun.org", "afcbf72bdbe770fcf2377cd42b4370f8-0f472795-ce7f06f5");
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