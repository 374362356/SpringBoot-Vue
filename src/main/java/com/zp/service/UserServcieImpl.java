package com.zp.service;

import com.zp.dao.UserDao;
import com.zp.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional //控制事务
public class UserServcieImpl  implements UserServcie{

    @Autowired
    private UserDao userDao;


    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<User> findall() {
        return userDao.findAll();
    }

    @Override
    public void saveUser(User user) {
        user.setId(UUID.randomUUID().toString().substring(1,4));
        userDao.saveUser(user);
    }

    @Override
    public void deleteUser(String id) {
        userDao.deleteUser(id);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public User findUserById(String id) {
        return userDao.findUserById(id);
    }

    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<User> findNameOrPhone(String name, String phone) {
        return userDao.findNameOrPhone(name, phone);
    }
}
