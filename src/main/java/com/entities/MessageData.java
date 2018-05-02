/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entities;

import java.util.Date;

/**
 *
 * @author andrei
 */
public class MessageData {
    private String sender;
    private String recipient;
    private String subject;
    private String text;
    private Date date;

    public MessageData() {
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }
    
    
    
    

    @Override
    public String toString() {
        return "Message{" + "recipient=" + recipient + ", subject=" + subject + ", text=" + text + '}';
    }
    
    
}
