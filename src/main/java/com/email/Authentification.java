/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.email;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

/**
 *
 * @author andrei
 */
public class Authentification extends Authenticator{
    String email;
    String password;

    public Authentification(String userName, String password) {
        this.email = userName;
        this.password = password;
        getPasswordAuthentication();
    }
    
    
    

    @Override
    protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(email, password); 
    }
    
}
