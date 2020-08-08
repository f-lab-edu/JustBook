package com.youngsuk.bookstore.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {
  private String userId;
  private String userPassword;
  private String userName;
  private String userEmail;
  private String userMessage;
}
