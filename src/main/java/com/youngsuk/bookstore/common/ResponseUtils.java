package com.youngsuk.bookstore.common;

import com.youngsuk.bookstore.dto.User;

//사용자에게 HTTP Response를 json으로 전달하는 내용을 추가 or 수정 or 삭제 해주는 클래스 입니다.
public class ResponseUtils {

    public static final String loginSuccessMessage = "로그인 성공";
    public static final String loginFailureMessage = "로그인 실패 비밀번호 오류";
    public static final String userAddSuccessMessage = "회원가입 성공";

    public static void makeUserAddResponseInformation(User user) {
        user.setUserPassword("*********");
        user.setUserMessage(userAddSuccessMessage);
    }

    public static void makeLoginResponseInformation(User user, boolean isLoginSuccess) {
        String loginMessage;

        if(isLoginSuccess) {
            loginMessage = loginSuccessMessage;
        }
        else {
            loginMessage = loginFailureMessage;
        }
        user.setUserPassword("*********");
        user.setUserMessage(loginMessage);
    }

}
