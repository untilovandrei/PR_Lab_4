/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controllers;

import com.email.Connector;
import com.entities.User;
import com.validator.UserValidator;
import java.util.logging.Logger;
import javax.mail.NoSuchProviderException;
import javax.servlet.http.HttpSession;
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
@SessionAttributes("connector")
public class LogInController {

    private static final Logger LOG = Logger.getLogger(LogInController.class.getName());
    
    @ModelAttribute("user")
    public User setupUser(){
        return new User();
    }
    
    @ModelAttribute("connector")
    public Connector setupConnector(){
        return new Connector();
    }
    
    @RequestMapping("/spring-mvc/logIn.html")
    public String logIn(){
        return "logIn";
    }
    
    @RequestMapping("/spring-mvc/attempt/logIn.html")
    public String logInAttempt(@ModelAttribute("user")User user, BindingResult result, HttpSession session,Model model) throws NoSuchProviderException{
        boolean validation=new UserValidator(result).validate(user);
        if(validation){
            Connector connector=(Connector) session.getAttribute("connector");
            //LOG.info("$$$$ Alive Before= "+ connector.isAlive());
            connector.setupSession();
            connector.connect(user);
            if(connector.isAlive()){
                session.setAttribute("loggedUser", user);
                //return "redirect:/spring-mvc/newEmail.html";
                return "redirect:/spring-mvc/inbox.html";
            }
        }
        model.addAttribute("user",new User());
        return "logIn";
    }
    
}
