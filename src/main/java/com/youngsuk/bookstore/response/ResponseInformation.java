package com.youngsuk.bookstore.response;

import com.youngsuk.bookstore.dto.User;
import org.springframework.stereotype.Component;


import static com.youngsuk.bookstore.response.ResponseMessage.*;

@Component
public class ResponseInformation {

    public void makeUserAddResponseInformation(User user) {
        user.setUserPassword("*********");
        user.setUserMessage(userAddSuccessMessage);
    }

    public void makeLoginResponseInformation(User user, boolean isLoginSuccess) {
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
