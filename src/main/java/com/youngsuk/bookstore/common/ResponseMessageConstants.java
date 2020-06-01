package com.youngsuk.bookstore.common;

//사용자에게 Response 데이터를 전달할때 사용되는 메시지 데이터가 담겨있는 클래스 입니다.
public class ResponseMessageConstants {

    //유틸성 클래스는 객체를 생성할 필요가 없기 때문에 private 생성자를 만들어 주었습니다.
    private ResponseMessageConstants() {}

    public static final String loginSuccessMessage = "로그인 성공";
    public static final String loginFailureMessage = "로그인 실패 비밀번호 오류";
    public static final String userAddSuccessMessage = "회원가입 성공";
}
