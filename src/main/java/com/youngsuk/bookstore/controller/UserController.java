package com.youngsuk.bookstore.controller;

import com.youngsuk.bookstore.common.utils.LoginResponseUtils;
import com.youngsuk.bookstore.dto.UserDTO;
import com.youngsuk.bookstore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static com.youngsuk.bookstore.common.utils.constants.ResponseMessageConstants.loginFailureMessage;
import static com.youngsuk.bookstore.common.utils.constants.ResponseMessageConstants.loginSuccessMessage;
import static com.youngsuk.bookstore.common.utils.constants.SessionKeyConstants.levelOne;

/*
[@RestController 공부내용]
@Controller의 기능에 @ResponseBody 기능이 추가된 것이다.
@Controller는 view를 리턴하는 반면에 @ResponseBody는 Json/XML을 반환한다.
@RestController 어노테이션을 추가하면 해당 클래스에 있는 핸들러들은 모두 json/XML을 리턴하게 된다.
*/

@RestController
public class UserController {

  @Autowired
  private UserService userService;

  /*
  [@PostMapping 공부내용]
  이전에는 @Requestmapping의 속성에 RequestMethod.Post라는 값을 넣어줘야 post 방식으로 값을 받을 수 있었다.
  하지만 코드를 짧게 줄이기 위해서 @PostMapping 어노테이션이 만들어졌다.
  주소값만 추가해주면 post 방식으로 값을 받을 수 있도록 만들어졌다.
  */

  @PostMapping(path = "/users")
  public ResponseEntity<UserDTO> userRegister(UserDTO userDTO) {
    userService.insertUserData(userDTO);
    return ResponseEntity.status(HttpStatus.CREATED).body(userDTO);
  }

  @PostMapping(path = "/users/login")
  public ResponseEntity<UserDTO> login(UserDTO userDTO, HttpServletRequest request) {
    boolean loginSuccess = userService.isUserPasswordCorrect(userDTO);

    if (loginSuccess) {
      HttpSession session = request.getSession();
      session.setAttribute(levelOne, userDTO.getUserId());
      userDTO = LoginResponseUtils.makeLoginResponseUserInformation(loginSuccessMessage, userDTO);

      return ResponseEntity.status(HttpStatus.OK).body(userDTO);
    } else {
      userDTO = LoginResponseUtils.makeLoginResponseUserInformation(loginFailureMessage, userDTO);

      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(userDTO);
    }
  }

}


