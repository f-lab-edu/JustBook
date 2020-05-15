package com.youngsuk.bookstore.dao;

import com.youngsuk.bookstore.dto.User;
import org.apache.ibatis.session.SqlSession;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
    /***
     * 접근 제어자
     *     1. Private (변수나 메소드에 private 접근제어자가 붙어있는 경우)
     * 	  - 변수 메소드 해당 클래스 안에서만 접근가능하다
     *
     *     2. Default (변수나 메소드에 접근 제어자를 지정하지 않는 경우)
     *    - 해당 패키지 내에 있는 다른 클래스에서 객체를 생성하면 Default 접근제어자로 만들어진 변수나 메소드를 사용할 수 있다.
     *
     *    3. Protected (변수나 메소드에 protected 접근제어자가 붙어있는 경우)
     *    -  동일 패키지의 클래스 또는 해당 클래스를 상속 받은 외부 클래스에서 Protected가 붙은 메소드나 변수에 접근이 된다.
     *
     *    4 Public (변수남 메소드에 Public 접근제어자가 붙어있는 경우)
     *    -  어떤 클래스에서든지 접근 가능하다.
     */


    //NAMESPACE 변수가 수정되면 쿼리문이 동작하지 않기 때문에 private final 추가.
    //NAMESPACE 변수를 사용해서 쿼리를 여러번 날리기 때문에 메모리를 절약하기 위해서 static 키워드 사용함.
    private final static String NAMESPACE = "com.youngsuk.bookstore.dao.UserDao";

    @Autowired
    private SqlSession sqlSession;

    public int insertUserData(User user){
        makeUserPasswordEncrypt(user);
        return sqlSession.insert(NAMESPACE + "insertUserData", user);
    }

    private void makeUserPasswordEncrypt(User user) {
        String hashedPassword = BCrypt.hashpw(user.getUserPassword(), BCrypt.gensalt());
        user.setUserPassword(hashedPassword);
    }

}
