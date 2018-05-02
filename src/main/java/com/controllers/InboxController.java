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
    
    
    
    
    
    @RequestMapping("/spring-mvc/inbox.html")
    public String loadInboxPage(Model model, HttpSession session) throws MessagingException{
        return "inbox";
    }
}
