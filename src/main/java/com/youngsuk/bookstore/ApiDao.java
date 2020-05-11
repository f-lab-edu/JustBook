package com.youngsuk.bookstore;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ApiDao {
    protected static final String NAMESPACE = "com.youngsuk.bookstore.";

    @Autowired
    //쿼리를 실행 하거나 데이터베이스의 commit rollback을 사용할 수 있도록 해주는 객체.
    private SqlSession sqlSession;

    public String selectName(){
        return sqlSession.selectOne(NAMESPACE + "selectName");
    }
}
