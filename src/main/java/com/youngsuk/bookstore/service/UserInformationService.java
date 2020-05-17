package com.youngsuk.bookstore.service;

import com.youngsuk.bookstore.dto.User;
import com.youngsuk.bookstore.repository.UserRepository;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Service
public class UserInformationService {

    @Autowired
    private UserRepository userRepository;

    public void makeUserPasswordEncrypt(User user) {
        String hashedPassword = BCrypt.hashpw(user.getUserPassword(), BCrypt.gensalt());
        user.setUserPassword(hashedPassword);
        inserUserData(user);
    }

    public void inserUserData(User user) {
        userRepository.insertUserForRegister(user);
    }

    public boolean isUserPasswordCollect(User user) {
        String password = userRepository.selectUserForConfirmPassword(user);
        return BCrypt.checkpw(user.getUserPassword(), password);
    }

    public void setUserSession(User user, HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.setAttribute("userId",user.getUserId());
        //로그인한 사용자가 결제 페이지에 머무르는 시간이 가장 많을것이라고 생각했다.
        //사용자가 이사를해서 주소를 새로 입력하거나 핸드폰을 바꿔서 번호를 바꿀 수도 있기 때문이다.
        //결제를 할때도 시간이 걸릴것이라고 생각했다. 이런 시간들을 고려했을때 10분이면 적절할것이라고 생각했다.
        session.setMaxInactiveInterval(60*10);
    }


}


