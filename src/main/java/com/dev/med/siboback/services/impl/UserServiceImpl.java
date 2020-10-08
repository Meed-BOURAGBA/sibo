package com.dev.med.siboback.services.impl;

import com.dev.med.siboback.data.UserDao;
import com.dev.med.siboback.entities.users.User;
import com.dev.med.siboback.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    public String addNewUser(User user) {
        return userDao.addNewUser(user);
    }

    @Override
    public List<User> getUsers(){
        return userDao.getUsers();
    }
}
