package com.youngsuk.bookstore.service;

import com.youngsuk.bookstore.dto.UserDto;
import org.springframework.stereotype.Service;

public interface UserService {
  public boolean selectUserPassword(UserDto userDto);
  public void insertUser(UserDto userDto);
  public void deleteUser(String userId);
  public void updateUser(UserDto userDto);
}
