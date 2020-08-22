package com.youngsuk.bookstore.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static com.youngsuk.bookstore.common.utils.constants.SessionKeyConstants.USER_SESSION_KEY;

@Aspect
@Component
public class SessionCheckAspect {

  @Autowired
  private HttpSession session;

  @Pointcut("@annotation(com.youngsuk.bookstore.common.utils.annoation.Authorized)")
  public void authorized() {}

  @Before(value = "authorized()")
  public void checkSessionValid(JoinPoint joinPoint) {

   // @Authorized 추가된 메소드의 파라미터에서 첫번째 값을 가져온다.
    String userId = (String) joinPoint.getArgs()[0];
    String userSession = (String) session.getAttribute(USER_SESSION_KEY);

    if(!userSession.equals(userId)) {
      throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Not Authorized");
    }
  }
}
