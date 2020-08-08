package com.youngsuk.bookstore.common.utils;

import com.youngsuk.bookstore.dto.UserDTO;

import static com.youngsuk.bookstore.common.utils.constants.ResponseMessageConstants.*;

//사용자에게 로그인에 관련한 HTTP Response를 json으로 전달하는 내용을 변경하는 유틸성 클래스 입니다.
public class LoginResponseUtils {

  private LoginResponseUtils() {}

  /* 사용자들이 로그인을 할때 객체 생성 하는 횟수가 많아지게 하는것보다
  static을 통해서 객체 생성 횟수를 줄이는 방법이 효율적이라 생각해서 static을 사용하였습니다*/

  public static UserDTO maskingUserPassword(UserDTO userDTO) {
    userDTO.setUserPassword(userPasswordMask);
    userDTO.setUserMessage(userAddSuccessMessage);

    return userDTO;
  }

  public static UserDTO makeLoginResponseUserInformation(String loginMessage, UserDTO userDTO) {
    userDTO.setUserPassword(userPasswordMask);
    userDTO.setUserMessage(loginMessage);

    return userDTO;
  }
}
