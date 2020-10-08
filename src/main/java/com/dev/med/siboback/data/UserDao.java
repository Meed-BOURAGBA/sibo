package com.dev.med.siboback.data;

import com.dev.med.siboback.entities.users.User;

import java.util.List;

public interface UserDao {

    String addNewUser(User user);
    List<User> getUsers();
}
