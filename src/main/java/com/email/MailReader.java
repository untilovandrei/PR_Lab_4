/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.email;

import com.entities.User;
import java.io.IOException;
import java.util.Properties;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Store;

/**
 *
 * @author andrei
 */
public class MailReader{
    Folder inbox;
    User user;
    Session session;

    public MailReader(User user) {
        this.user = user;
        this.session=getSession();
    }
 
    
    
    private Session getSession() {
        Properties props = System.getProperties();
        props.setProperty("mail.store.protocol", "imaps");
        
        return session= Session.getInstance(props,null); 
    }
    
    
    public int getUnreadMessages() throws NoSuchProviderException, MessagingException{
//LogIn
//        Store store = session.getStore("imaps");
//        store.connect("imap.gmail.com",user.getEmail(),user.getPassword());
        int unreadMsg=-1;
        Connector conn=new Connector(session);
        boolean authentification=conn.connect(user);
        if(authentification){
            inbox = conn.getStore().getFolder("Inbox");
            unreadMsg=inbox.getUnreadMessageCount();
            inbox.open(Folder.READ_WRITE);
            System.out.println("No of Unread Messages : " + unreadMsg);
        }
        
    
        
        
        return unreadMsg;
    }
    
    
    public void getLast50Emails() throws NoSuchProviderException, MessagingException, IOException{
        Store store = session.getStore("imaps");
        store.connect("imap.gmail.com",user.getEmail(),user.getPassword());
        inbox = store.getFolder("Inbox");
        inbox.open(Folder.READ_WRITE);
        Message[] arrayMessages = inbox.getMessages();
        
        for (int i = arrayMessages.length-1; i >= arrayMessages.length-50; i--) {
            Message message = arrayMessages[i];
            System.out.println("---------------------------------");
            System.out.println("Email Number " + (arrayMessages.length-i));
            System.out.println("Subject: " + message.getSubject());
            System.out.println("Date: " + message.getReceivedDate());
            System.out.println("From: " + message.getFrom()[0]);
            



      }
    }
    
    
    
   
    
    
    
}