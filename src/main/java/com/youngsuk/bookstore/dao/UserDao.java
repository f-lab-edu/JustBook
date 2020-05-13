package com.youngsuk.bookstore.dao;

import com.youngsuk.bookstore.dto.User;
import org.apache.ibatis.session.SqlSession;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
    protected static final String NAMESPACE = "com.youngsuk.bookstore.";

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
