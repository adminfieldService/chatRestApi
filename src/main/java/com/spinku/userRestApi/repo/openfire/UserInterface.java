/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spinku.userRestApi.repo.openfire;

import com.spinku.userRestApi.entity.Ofuser;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author newbi
 */
public interface UserInterface extends CrudRepository<Ofuser, Long>{
    
}
