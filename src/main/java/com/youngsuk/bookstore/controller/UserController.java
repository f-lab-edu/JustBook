package com.youngsuk.bookstore.controller;

import com.youngsuk.bookstore.dto.User;
import com.youngsuk.bookstore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/***
 * [@RestController 공부내용]
 * @Controller의 기능에 @ResponseBody 기능이 추가된 것이다.
 * @Controller는 view를 리턴하는 반면에 @ResponseBody는 Json/XML을 반환한다.
 * @RestController 어노테이션을 추가하면 해당 클래스에 있는 핸들러들은 모두 json/XML을 리턴하게 된다.
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    /***
     *[@PostMapping 공부내용]
     * 이전에는 @Requestmapping의 속성에 RequestMethod.Post라는 값을 넣어줘야 post 방식으로 값을 받을 수 있었다.
     * 하지만 코드를 짧게 줄이기 위해서 @PostMapping 이라는 어노테이션에 주소값만 추가해주면 post 방식으로 값을 받을 수 있다.
     */
    @PostMapping(path = "/users")
    public User addUser(User user) {
        userService.makeUserPasswordEncrypt(user);
        return user;
    }
}
