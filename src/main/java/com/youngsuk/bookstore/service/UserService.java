package com.youngsuk.bookstore.service;

import com.youngsuk.bookstore.dto.UserDto;
import com.youngsuk.bookstore.repository.UserRepository;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  @Autowired
  private UserRepository userRepository;

  public void insertUserData(UserDto userDto) {
    String hashedPassword = BCrypt.hashpw(userDto.getUserPassword(), BCrypt.gensalt());
    userDto.setUserPassword(hashedPassword);
    userRepository.insertUserData(userDto);
  }

  public boolean isUserPasswordCorrect(UserDto userDto) {
    String password = userRepository.selectUserForConfirmPassword(userDto);
    return BCrypt.checkpw(userDto.getUserPassword(), password);
  }


}


