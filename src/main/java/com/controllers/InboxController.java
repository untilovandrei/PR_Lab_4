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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author andrei
 */
@Controller
public class InboxController {
    static int nrOfMessages=5;
    
    private static final Logger LOG = Logger.getLogger(InboxController.class.getName());
    
    
    @ModelAttribute("messagesList")
    public List<MessageData> setupInboxPage(HttpSession session) throws MessagingException{
        Connector connector= (Connector) session.getAttribute("connector");
        Store store=connector.getStore();
        Folder inbox = store.getFolder("Inbox");
        inbox.open(Folder.READ_WRITE);
        List<MessageData> messagesList = new ArrayList<>();
        Message[] arrayMessages = inbox.getMessages();
        
        int id=1;
        for (int i = arrayMessages.length-1; i >= arrayMessages.length-nrOfMessages; i--) {
            Message message=arrayMessages[i];
            MessageData messageData= new MessageData();
            messageData.setId(id);
            messageData.setSubject(message.getSubject());
            messageData.setDate(message.getReceivedDate());
            messageData.setSender(message.getFrom()[0].toString());
            LOG.info("---------------------------------");
            LOG.info("Email Number " + messageData.getId());
            LOG.info("Subject: " + messageData.getSubject());
            LOG.info("Date: " + messageData.getDate());
            LOG.info("From: " + messageData.getSender());
            messagesList.add(messageData);
            id++;
      }
        MessageData.setList(messagesList);
        return messagesList;
        
    }
    
    
    @RequestMapping("/spring-mvc/inbox.html")
    public String loadInboxPage() throws MessagingException{
        return "inbox";
    }
    
    
    @RequestMapping("/spring-mvc/readMessage/{id}/message.html")
    public String readMessage(@PathVariable int id, Model model, HttpSession session){
        MessageData message=MessageData.getList().get(Integer.valueOf(id)-1);
        LOG.info("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
            LOG.info("Email Number " + message.getId());
            LOG.info("Subject: " + message.getSubject());
            LOG.info("Date: " + message.getDate());
            LOG.info("From: " + message.getSender());
        model.addAttribute("message", message);
        
       return "readMessage";
    }
    
    
    @RequestMapping("/spring-mvc/logOut.html")
    public String logOut( HttpSession session){
        session.removeAttribute("loggedUser");
        return "redirect:spring-mvc/logIn.html";
    }
}
