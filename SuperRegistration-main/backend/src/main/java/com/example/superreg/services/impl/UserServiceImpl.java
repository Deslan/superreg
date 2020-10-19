package com.example.superreg.services.impl;

import com.example.superreg.entities.User;
import com.example.superreg.repository.UserRepository;
import com.example.superreg.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User saveUser(User user) {
        if(isValidUser(user)) {
            userRepository.save(user);
            return user;
        }
        else {
            throw new RuntimeException("USER_PROVIDED_WAS_INVALID");
        }
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public boolean isValidUser(User user){
        if(
           nameIsValid(user.getName()) &&
           telephoneNumberIsValid(user.getTelephoneNumber()) &&
           idIsValid(user.getIdNumber())
        ) return true;
        return false;
    }

    public boolean nameIsValid(String name) {
        if(name.isEmpty()) return false;
        return name.matches("[a-zA-Z\\s]+");
    }
    public boolean telephoneNumberIsValid(String telephoneNumber) {
       return telephoneNumber.matches("^\\+27[0-9]{9}$");
    }

    public boolean idIsValid(Long idNumber) {
        return checkLuhn(BigInteger.valueOf(idNumber));
    }

    private static Boolean checkLuhn(BigInteger idNumber){
        char[] idcharacters = idNumber.toString().toCharArray();
        int sum = 0;
        for (int i = 1; i <= idcharacters.length; i++) {
            int digit = Character.getNumericValue(idcharacters[idcharacters.length - i]);
            if ((i % 2) != 0) {
                sum += digit;
            } else {
                sum += digit < 5 ? digit * 2 : digit * 2 - 9;
            }
        }
        return (sum % 10) == 0;
    }
}
