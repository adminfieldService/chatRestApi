package com.spinku.userRestApi.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.spinku.userRestApi.entity.user.EntityContacts;
import com.spinku.userRestApi.entity.user.EntityUsers;
import com.spinku.userRestApi.repo.user.EntityContactsDao;

@Service("contactService")
public class ContactService {

    @Autowired
    @Qualifier("contactDao")
    private EntityContactsDao contactDao;

    @Transactional
    public void addContact(EntityContacts dataContact) {
        contactDao.insertContact(dataContact);
    }

    @Transactional
    public List<EntityContacts> getAllContact() {
        return contactDao.selectAllContact();

    }

//    @Transactional
//    public List<EntityUsers> getAllUser() {
//        return contactDao.selectAllUser();
//
//    }

    @Transactional
    public List<EntityContacts> findByIdUser(Long id_user) {
        return contactDao.findByIdUser(id_user);
    }

}
