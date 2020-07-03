package com.youngsuk.bookstore.repository;

import com.youngsuk.bookstore.dto.User;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import static com.youngsuk.bookstore.common.constants.MyBatisNameSpaceConstants.UserRepositoryNameSpace;


/***
 * [@Component, @Controlloer, @Service, @Repository 어노테이션 공부 정리]
 *
 * 아키텍처에서 해당하는 역할들을 담당하는 클래스에 달리는 어노테이션 중 하나 (aka. stereotype annotation)
 * stereotype은 한국말로 번역하면 틀에 박힌 방식이라는 뜻
 * @Service, @Repository, @Controller 어노테이션을 추가하면, 빈에 등록되고 해당 layer에 부여된 어노테이션의 특수한 역할을 추가할 수 있다. 그리고 AOP를 사용할때 좋다고 한다 [다시 알아볼 필요 있음]
 * @Component 어노테이션은 위의 3가지 어노테이션의 공통적인 기능을 가지고 있다.
 *
 * [스프링 MVC layer]
 * 1. presentation layer (@Controller 사용)
 *  - 사용자의 요청을 받고 해당 요청에 대한 요구사항을 Service layer를 통해 받아서 사용자에게 건내주는 역할을 한다.
 * 2. Service layer (@Service 사용)
 *  - 비즈니스 로직을 처리하는 역할을 한다. 예를들어 시청 인원수를 올린다던가, 결제를 처리한다던가 하는 역할을 한다.
 *  - Service layer가 필요한 이유는 관심사를 분리해서 유지보수를 편하게 할 수 있기 위해서다.
 * 3. persistance layer (@Repository 사용)
 *  - 데이터를 저장하고 삭제하고 수정하는등의 역할을 한다.
 */

@Repository
public class UserRepository {
    /***
     * [접근 제어자 공부 정리]
     *
     *     1. Private (변수나 메소드에 private 접근제어자가 붙어있는 경우)
     * 	  - 변수 메소드 해당 클래스 안에서만 접근가능하다
     *
     *     2. Default (변수나 메소드에 접근 제어자를 지정하지 않는 경우)
     *    - 해당 패키지 내에 있는 다른 클래스에서 객체를 생성하면 Default 접근제어자로 만들어진 변수나 메소드를 사용할 수 있다.
     *
     *    3. Protected (변수나 메소드에 protected 접근제어자가 붙어있는 경우)
     *    -  동일 패키지의 클래스 또는 해당 클래스를 상속 받은 외부 클래스에서 Protected가 붙은 메소드나 변수에 접근이 된다.
     *
     *    4 Public (변수나 메소드에 Public 접근제어자가 붙어있는 경우)
     *    -  어떤 클래스에서든지 접근 가능하다.
     */

    @Autowired
    private SqlSession sqlSession;

    public int insertUserForRegister(User user){
        return sqlSession.insert(UserRepositoryNameSpace + "insertUserForRegister", user);
    }

    public String selectUserForConfirmPassword(User user){
        return sqlSession.selectOne(UserRepositoryNameSpace + "selectUserData", user.getUserId());
    }
}
