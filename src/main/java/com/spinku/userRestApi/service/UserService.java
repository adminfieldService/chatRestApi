package com.spinku.userRestApi.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.spinku.userRestApi.entity.Ofuser;
import com.spinku.userRestApi.repo.openfire.UserDao;

@Service("userService")
public class UserService {

    @Autowired
    @Qualifier("userDao")
    private UserDao userDao;

    @Transactional
    public Ofuser getUserById(long userId) {

        return userDao.selectUserById(userId);
    }

    @Transactional
    public void addUser(Ofuser user) {
        userDao.insertUser(user);
    }

    @Transactional
    public void modifyUser(Ofuser user) {
        userDao.updateUser(user);
    }

    @Transactional
    public void removeUser(long userId) {
        userDao.deleteUser(userId);

    }

    @Transactional
    public List<Ofuser> getAllUser() {
        return userDao.selectAllUser();

    }

    @Transactional
    public void cekUsers(String emailUser, String password, String apkVer) {
        userDao.loginUser(emailUser, password, apkVer);

    }

    @Transactional
    public List<Ofuser> findByEmail(String email) {
        return userDao.findByEmail(email);
    }

}
