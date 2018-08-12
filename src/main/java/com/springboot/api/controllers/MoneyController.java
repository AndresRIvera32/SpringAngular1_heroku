/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springboot.api.controllers;

import com.springboot.api.model.RegistryModel;
import com.springboot.api.services.ServicesFacade;
import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author andresriv
 */
@RestController
@RequestMapping("/changes")
@CrossOrigin
public class MoneyController {
    
    @Autowired
    ServicesFacade services;
    

    
    @RequestMapping(value = "/getPrice",method = RequestMethod.GET)        
    public RegistryModel getPrice(double dolar,double eur) { 
            return services.convertEuro(dolar, eur);
    } 
    
    @GetMapping(value= "")
    public String ejemplo(){
    	return "";
    }
    
    
}

