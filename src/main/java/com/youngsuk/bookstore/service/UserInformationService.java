package com.youngsuk.bookstore.service;

import com.youngsuk.bookstore.dto.User;
import com.youngsuk.bookstore.repository.UserRepository;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Service
public class UserInformationService {

    @Autowired
    private UserRepository userRepository;

    public void makeUserPasswordEncrypt(User user) {
        String hashedPassword = BCrypt.hashpw(user.getUserPassword(), BCrypt.gensalt());
        user.setUserPassword(hashedPassword);
        inserUserData(user);
    }

    public void inserUserData(User user) {
        userRepository.insertUserForRegister(user);
    }

    public boolean isUserPasswordCollect(User user) {
        String password = userRepository.selectUserForConfirmPassword(user);
        return BCrypt.checkpw(user.getUserPassword(), password);
    }


}


