/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spinku.userRestApi.repo.user;

import com.spinku.userRestApi.entity.user.EntityContacts;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author newbi
 */
public interface ContactInterface extends CrudRepository<EntityContacts, Long>{

    
}
