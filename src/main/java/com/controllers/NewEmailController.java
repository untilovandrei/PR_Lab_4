/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controllers;

import com.email.Connector;
import com.email.MailSender;
import com.entities.MessageData;
import com.entities.User;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 *
 * @author andrei
 */
@Controller
public class NewEmailController {

    private static final Logger LOG = Logger.getLogger(NewEmailController.class.getName());
    
    
    @ModelAttribute("newMessage")
    public MessageData setupNewMessagePage(){
        return new MessageData();
    }
    
    @RequestMapping("/spring-mvc/newMessage.html")
    public String loadNewMailPage(HttpSession session){
        Connector connector=(Connector) session.getAttribute("connector");
        //LOG.info("$$$$ Alive After= "+ connector.isAlive());
        return "newMessage";
    }
    
    @RequestMapping("/spring-mvc/attempt/sendMessage.html")
    public String sendMessage(@ModelAttribute("message") MessageData message,HttpSession session){
            User user=(User) session.getAttribute("loggedUser");
            LOG.info("**** "+user.toString());
            passEmail(user,message);
        
        return "redirect:/spring-mvc/inbox.html";
    }
    
    
    public void passEmail(User user, MessageData message){
        try {
            MailSender transporter=new MailSender(user,message.getRecipient());
            transporter.getMessage().setSubject(message.getSubject());
            transporter.getMessage().setText(message.getText());
            transporter.sendMessage();
        } catch (MessagingException ex) {
            Logger.getLogger(NewEmailController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
