package com.youngsuk.bookstore.service;

import com.youngsuk.bookstore.dto.User;
import com.youngsuk.bookstore.repository.UserRepository;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInformationService {

    @Autowired
    private UserRepository userRepository;

    public User makeUserPasswordEncrypt(User user) {
        String hashedPassword = BCrypt.hashpw(user.getUserPassword(), BCrypt.gensalt());
        user.setUserPassword(hashedPassword);
        insertUserData(user);
        return user;
    }

    public void insertUserData(User user) {
        userRepository.insertUserForRegister(user);
    }

    public boolean isUserPasswordCorrect(User user) {
        String password = userRepository.selectUserForConfirmPassword(user);
        return BCrypt.checkpw(user.getUserPassword(), password);
    }


}


