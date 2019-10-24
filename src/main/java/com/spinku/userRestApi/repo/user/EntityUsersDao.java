/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spinku.userRestApi.repo.user;

import com.spinku.userRestApi.entity.user.EntityUsers;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author field
 */
public class EntityUsersDao {

    @PersistenceContext
    private EntityManager entityManager;

    public List<EntityUsers> selectAllUser() {
        Query query = entityManager.createQuery("SELECT us FROM EntityUsers us");
        return (List<EntityUsers>) query.getResultList();
    }
}
