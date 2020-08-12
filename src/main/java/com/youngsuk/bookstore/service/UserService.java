package com.youngsuk.bookstore.service;

import com.youngsuk.bookstore.dto.UserDTO;
import com.youngsuk.bookstore.repository.UserRepository;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  @Autowired
  private UserRepository userRepository;

  public void insertUserData(UserDTO userDTO) {
    String hashedPassword = BCrypt.hashpw(userDTO.getUserPassword(), BCrypt.gensalt());
    userDTO.setUserPassword(hashedPassword);
    userRepository.insertUserData(userDTO);
  }

  public boolean isUserPasswordCorrect(UserDTO userDTO) {
    String password = userRepository.selectUserForConfirmPassword(userDTO);
    return BCrypt.checkpw(userDTO.getUserPassword(), password);
  }


}


