package com.youngsuk.bookstore.controller;

import com.youngsuk.bookstore.dto.UserDto;
import com.youngsuk.bookstore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import static com.youngsuk.bookstore.common.utils.constants.SessionKeyConstants.USER_SESSION_KEY;

@RestController
@RequestMapping("/login")
public class LoginController {

  @Autowired
  private UserService userService;

  @PostMapping
  public ResponseEntity<UserDto> login(UserDto userDto,
                                       HttpSession session,
                                       HttpServletResponse response) {

    boolean loginSuccess = userService.isUserPasswordCorrect(userDto);

    if (loginSuccess) {
      session.setAttribute(USER_SESSION_KEY, userDto.getUserId());
      return ResponseEntity.status(HttpStatus.OK).body(userDto);
    } else {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "check id or password");
    }
  }
}
