package com.youngsuk.bookstore.aspect;

import com.youngsuk.bookstore.exception.LoginRequiredException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.http.HttpSession;

import static com.youngsuk.bookstore.common.utils.constants.SessionKeyConstants.USER_SESSION_KEY;

@Aspect
@Component
public class LoginCheckAspect {

  @Autowired
  private HttpSession session;

  @Pointcut("@annotation(com.youngsuk.bookstore.common.utils.annoation.Authorized)")
  public void authorized() {}

  @Before(value = "authorized()")
  public void checkSessionValid(JoinPoint joinPoint) {

   // @Authorized 추가된 메소드의 파라미터에서 첫번째 값을 가져온다.
    String userId = (String) joinPoint.getArgs()[0];
    String userSession = (String) session.getAttribute(USER_SESSION_KEY);

    if (userSession == null) {
      throw new LoginRequiredException();
    }

    if (userSession.equals(userId)){
    } else {
      throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Not Authorized");
    }
  }

}
