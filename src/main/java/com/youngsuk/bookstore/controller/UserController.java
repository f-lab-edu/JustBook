package com.youngsuk.bookstore.controller;

import com.youngsuk.bookstore.dao.UserDao;
import com.youngsuk.bookstore.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserDao userDao;

    @PostMapping(path = "/users")
    public User register(User user) {
        userDao.insertUserData(user);
        return user;
    }

}
