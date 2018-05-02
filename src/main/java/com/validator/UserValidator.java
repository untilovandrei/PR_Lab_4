/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.validator;

import com.entities.User;
import org.springframework.validation.BindingResult;

/**
 *
 * @author andrei
 */
public class UserValidator {
    BindingResult result;

    public UserValidator(BindingResult result) {
        this.result = result;
    }
    
    public boolean validate(User user){
        if(!result.hasErrors() && user.getEmail().contains("@gmail.com") && user.getPassword().length()>0){
            return true;
        }
        return false;
    }
    
    
}
