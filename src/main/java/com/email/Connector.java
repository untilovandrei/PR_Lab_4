/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.email;

import com.entities.User;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Store;

/**
 *
 * @author andrei
 */
public class Connector {
    private Session session;
    private Store store;
    private boolean alive;

    public Connector() {
    }

    public Connector(Session session) throws NoSuchProviderException {
        this.session = session;
        this.store = session.getStore("imaps");
    }
    
    public boolean connect(User user){
        try { 
            store.connect("imap.gmail.com",user.getEmail(),user.getPassword());
        } catch (MessagingException ex) {
            Logger.getLogger(Connector.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        this.alive=true;
        return true;
    }

    public Store getStore() {
        return store;
    }
    
    public void setupSession() throws NoSuchProviderException {
        Properties props = System.getProperties();
        props.setProperty("mail.store.protocol", "imaps");
        
        this.session= Session.getInstance(props,null); 
        this.store = this.session.getStore("imaps");
    }

    public boolean isAlive() {
        return this.alive;
    }
    
    
    
    
    
}
