package com.youngsuk.bookstore.common;

import com.youngsuk.bookstore.dto.User;

import static com.youngsuk.bookstore.common.ResponseMessage.*;

//사용자에게 로그인에 관련한 HTTP Response를 json으로 전달하는 내용을 변경하는 유틸성 클래스 입니다.
public class LoginResponse {

    private LoginResponse() {}

    //사용자들이 로그인을 할때 객체 생성 하는 횟수가 많아지게 하는것보다
    //static을 통해서 객체 생성 횟수를 줄이는 방법이 효율적이라 생각해서 static으로 만듬
    public static User makeUserAddResponseInformation(User user) {
        user.setUserPassword("*********");
        user.setUserMessage(userAddSuccessMessage);

        return user;
    }

    public static String makeLoginResponseSuccessMessage(boolean isLoginSuccess) {
        String loginMessage;

        if (isLoginSuccess) {
            loginMessage = loginSuccessMessage;
        }
        else {
            loginMessage = loginFailureMessage;
        }

        return loginMessage;
    }

    public static User makeLoginResponseUserInformation(String loginMessage, User user) {
        user.setUserPassword("*********");
        user.setUserMessage(loginMessage);

        return user;
    }

}