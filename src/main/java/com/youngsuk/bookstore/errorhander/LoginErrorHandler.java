package com.youngsuk.bookstore.errorhander;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//로그인을 했을때 클라이언트에게 로그인이 올바르게 됐는지 전달할때 사용되는 클래스 입니다.
public class LoginErrorHandler {
    private boolean isPasswordCorrect;
}
