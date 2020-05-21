package com.youngsuk.bookstore.controller;

import com.youngsuk.bookstore.common.ResponseMessage;
import com.youngsuk.bookstore.dto.User;
import com.youngsuk.bookstore.service.UserInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


/***
 * [@RestController 공부내용]
 * @Controller의 기능에 @ResponseBody 기능이 추가된 것이다.
 * @Controller는 view를 리턴하는 반면에 @ResponseBody는 Json/XML을 반환한다.
 * @RestController 어노테이션을 추가하면 해당 클래스에 있는 핸들러들은 모두 json/XML을 리턴하게 된다.
 */
@RestController
public class UserController {

    @Autowired
    private UserInformationService userInformationService;
    @Autowired
    private ResponseMessage responseMessage;

    /***
     *[@PostMapping 공부내용]
     * 이전에는 @Requestmapping의 속성에 RequestMethod.Post라는 값을 넣어줘야 post 방식으로 값을 받을 수 있었다.
     * 하지만 코드를 짧게 줄이기 위해서 @PostMapping 이라는 어노테이션에 주소값만 추가해주면 post 방식으로 값을 받을 수 있다.
     */
    @PostMapping(path = "/users")
    public ResponseEntity userAdd(User user) {
        String encryptPassword = userInformationService.makeUserPasswordEncrypt(user);
        user.setUserPassword(encryptPassword);
        responseMessage.makeUserAddResponseInformation(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    @PostMapping(path = "/users/login")
    public ResponseEntity userCheckPasswordGiveSession(User user, HttpServletRequest request) {
        boolean isloginSuccess;

        if(userInformationService.isUserPasswordCollect(user)) {
            setUserSession(user, request);
            isloginSuccess = true;
            responseMessage.makeLoginResponseInformation(user, isloginSuccess);
            return ResponseEntity.status(HttpStatus.OK).body(user);
        }
        else {
            isloginSuccess = false;
            responseMessage.makeLoginResponseInformation(user, isloginSuccess);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(user);
        }
    }

    private void setUserSession(User user, HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.setAttribute("userId",user.getUserId());
    }


}
