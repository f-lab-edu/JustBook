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

    public String makeUserPasswordEncrypt(User user) {
        String hashedPassword = BCrypt.hashpw(user.getUserPassword(), BCrypt.gensalt());
        user.setUserPassword(hashedPassword);
        inserUserData(user);
        return hashedPassword;
    }

    public void inserUserData(User user) {
        userRepository.insertUserForRegister(user);
    }

    public boolean isUserPasswordCollect(User user) {
        String password = userRepository.selectUserForConfirmPassword(user);
        return BCrypt.checkpw(user.getUserPassword(), password);
    }


}


