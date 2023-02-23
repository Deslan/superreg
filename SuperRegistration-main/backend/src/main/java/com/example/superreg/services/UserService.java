package com.example.superreg.services;

import com.example.superreg.entities.User;

import java.util.List;

public interface UserService {

    User saveUser(User user);
    List<User> getUsers();
}
