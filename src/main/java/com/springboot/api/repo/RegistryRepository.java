/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springboot.api.repo;

import com.springboot.api.entities.Registry;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author HOMERO
 */
public interface RegistryRepository extends CrudRepository<Registry, Number>{
    
}
