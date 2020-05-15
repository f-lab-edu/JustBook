package com.youngsuk.bookstore.service;

import com.youngsuk.bookstore.dao.UserDao;
import com.youngsuk.bookstore.dto.User;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserPasswordEncryptService implements UserService {

    @Autowired
    UserDao userDao;

    public void makeUserPasswordEncrypt(User user) {
        String hashedPassword = BCrypt.hashpw(user.getUserPassword(), BCrypt.gensalt());
        user.setUserPassword(hashedPassword);
        userDao.insertUserData(user);
    }

}
