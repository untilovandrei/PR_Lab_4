/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controllers;

import com.email.Connector;
import com.entities.MessageData;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Store;
import javax.servlet.http.HttpSession;
import org.aspectj.util.LangUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author andrei
 */
@Controller
public class InboxController {
    
    private static final Logger LOG = Logger.getLogger(InboxController.class.getName());
    
    
    @ModelAttribute("messagesList")
    public List<MessageData> setupInboxPage(HttpSession seesion) throws MessagingException{
        Connector connector= (Connector) seesion.getAttribute("connector");
        Store store=connector.getStore();
        Folder inbox = store.getFolder("Inbox");
        inbox.open(Folder.READ_WRITE);
        List<MessageData> messagesList = new ArrayList<>();
        Message[] arrayMessages = inbox.getMessages();
        
        
        for (int i = arrayMessages.length-1; i >= arrayMessages.length-50; i--) {
            Message message=arrayMessages[i];
            MessageData messageData= new MessageData();
            messageData.setSubject(message.getSubject());
            messageData.setDate(message.getReceivedDate());
            messageData.setSender(message.getFrom()[0].toString());
            LOG.info("---------------------------------");
            LOG.info("Email Number " + (arrayMessages.length-i));
            LOG.info("Subject: " + messageData.getSubject());
            LOG.info("Date: " + messageData.getDate());
            LOG.info("From: " + messageData.getSender());
            messagesList.add(messageData);
      }
        return messagesList;
        
    }
    
    
    @RequestMapping("/spring-mvc/inbox.html")
    public String loadInboxPage() throws MessagingException{
        return "inbox";
    }
}
