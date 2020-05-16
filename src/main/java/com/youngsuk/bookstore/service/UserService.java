package com.youngsuk.bookstore.service;

import com.youngsuk.bookstore.dto.User;

public interface UserService {
    void makeUserPasswordEncrypt(User user);
}
