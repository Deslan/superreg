package com.example.superreg.services;

import com.example.superreg.entities.User;

import java.util.List;

public interface UserService {

    public User saveUser(User user);
    public List<User> getUsers();
}
