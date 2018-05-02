/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.email;

import com.email.Authentification;
import com.entities.User;
import java.util.Properties;
import javax.mail.AuthenticationFailedException;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author andrei
 */
public class MailSender {
    private User user;
    private String recipient;
    private Message message;
    private Session session;


    public void setUser(User user) {
        this.user = user;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    
    
    

    public MailSender(User user, String recipient) throws AddressException, MessagingException{
        this.user = user;
        this.recipient = recipient;
        this.session=getSession(user);
        this.message=new MimeMessage(this.session);
        this.message.setFrom(new InternetAddress(user.getEmail()));
        this.message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(recipient));
    }
    
   public Session getSession(User user){
        Properties sendProperties=new Properties();
        sendProperties.put("mail.smtp.auth", "true");
        sendProperties.put("mail.smtp.starttls.enable", "true");
        sendProperties.put("mail.smtp.host", "smtp.gmail.com");
        sendProperties.put("mail.smtp.port", "587");
        Authentification a=new Authentification(user.getEmail(), user.getPassword());
        return Session.getInstance(sendProperties,a);
       
   }
   
   public void sendMessage() throws MessagingException{
       Transport.send(message);
       System.out.println("#Sent#");
   }
}
