package com.example.springbootExample.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springbootExample.exceptions.NotFoundException;
import com.example.springbootExample.models.User;
import com.example.springbootExample.repositories.UserRepository;


@RestController
@RequestMapping("/v1/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    List<User> userlist = null;
    public UserController() {
    }

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/listOfUsers")
    List<User> index() {
        System.out.println("Inside the method");
            return userRepository.findAll();
    }

 
    @PostMapping("/createUser")
    User create(@RequestBody User user) {
        
        try {
            return userRepository.save(user);
        } catch (Exception e) {
            e.printStackTrace();
           // user = userRepository.findFirstBySso(user.getSso());
           // user.setName(null);
           return user;
        }
    }

    @GetMapping("/{userId}")
    User getUser(@PathVariable(name = "userId") Long userId) {
        
        return userRepository.findById(userId).orElseThrow(NotFoundException::new);
    }

    @PutMapping("/{userId}")
    User updateUserName(@PathVariable(name = "userId") Long userId, @RequestBody User user
            ) {
        if (userRepository.existsById(userId)) {
            user.setId(userId);
            return userRepository.save(user);
        } else {
            throw new NotFoundException();
        }
    }

    @DeleteMapping("/{userId}")
    User deleteUser(@PathVariable(name = "userId") Long userId) {
            User user = userRepository.findById(userId).orElseThrow(NotFoundException::new);
            userRepository.delete(user);
            return user;
    }
}
