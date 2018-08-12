/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springboot.api.services;

import com.springboot.api.entities.Registry;
import com.springboot.api.model.RegistryModel;
import com.springboot.api.repo.RegistryRepository;
import java.text.DecimalFormat;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author andresrivera
 */
@Service
public class ServicesFacade {
	
	private static final Log LOG = LogFactory.getLog(ServicesFacade.class); 
    
    @Autowired
    private RegistryRepository repo;
   
    
    public RegistryModel convertEuro(double dolar, double eur){
         DecimalFormat formato = new DecimalFormat("###,###.##");
         double total = dolar*eur;
         String format = formato.format(total);
         System.out.println("FORMATEADO****"+format);
         RegistryModel p = new RegistryModel(dolar,eur,format);
         Registry r = new Registry(dolar,eur,format);
         System.out.println("TOTAL:"+total);
         //register(r);
         LOG.info("TOTAL:"+total);
         return p;
    }
    
    public void register(Registry r){
        repo.save(r);
        
    }
    
}
