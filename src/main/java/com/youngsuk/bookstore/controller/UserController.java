package com.youngsuk.bookstore.controller;

import com.youngsuk.bookstore.dao.UserDao;
import com.youngsuk.bookstore.dto.User;
import com.youngsuk.bookstore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping(path = "/users")
    public User addUser(User user) {
        userService.makeUserPasswordEncrypt(user);
        return user;
    }
}
