package com.example.superreg.controllers;

import com.example.superreg.entities.User;
import com.example.superreg.services.UserService;
import jdk.nashorn.internal.objects.NativeJSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/user")
public class UserAPI {

    private UserService userService;

    @Autowired
    public UserAPI(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/save")
    public ResponseEntity saveUser(@RequestBody User user) {
        System.out.println(">>>>>>> ATTEMPTING TO SAVE USER");
        try{
            userService.saveUser(user);
            System.out.println(">>>>>>> USER " + user.getName() + " SAVED SUCCESSFULLY");
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (RuntimeException e) {
            System.out.println(">>>>>>> USER " + user.getName() + " FAILED TO SAVE");
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/users")
    public List<User> getAllUsers(){
        System.out.println(">>>>>>> ATTEMPTING TO GET ALL USERS");
        return userService.getUsers();
    }
}
