package com.dev.med.siboback.services;

import com.dev.med.siboback.entities.users.User;

import java.util.List;

public interface UserService {
    String addNewUser(User user);
    List<User> getUsers();

}
