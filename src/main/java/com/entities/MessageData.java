/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 *
 * @author andrei
 */
public class MessageData implements Serializable{
    private int id;
    private String sender;
    private String recipient;
    private String subject;
    private String text;
    private Date date;
    private static List<MessageData> list;
    
    

    public MessageData() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public static List<MessageData> getList() {
        return list;
    }

    public static void setList(List<MessageData> list) {
        MessageData.list = list;
    }
    
    
    
    

    @Override
    public String toString() {
        return "Message{" + "recipient=" + recipient + ", subject=" + subject + ", text=" + text + '}';
    }
    
    
}
