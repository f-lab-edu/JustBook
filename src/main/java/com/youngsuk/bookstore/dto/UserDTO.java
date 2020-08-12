package com.youngsuk.bookstore.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;

@Getter
public class UserDTO {

  private String userId;
  @JsonIgnore
  private String userPassword;
  private String userName;
  private String userEmail;

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public void setUserPassword(String userPassword) {
    this.userPassword = userPassword;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public void setUserEmail(String userEmail) {
    this.userEmail = userEmail;
  }
}
