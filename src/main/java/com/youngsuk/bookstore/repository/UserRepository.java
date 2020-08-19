package com.youngsuk.bookstore.repository;

import com.youngsuk.bookstore.dto.UserDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import static com.youngsuk.bookstore.common.utils.constants.MyBatisNameSpaceConstants.UserRepositoryNameSpace;


/*
[@Component, @Controlloer, @Service, @Repository 어노테이션 공부 정리]
1. Spring Mvc 구조에 해당하는 역할에 맞는 클래스에 달리는 어노테이션이다.
이 어노테이션 들은 stereotype 어노테이션이라고도 불리는데
한국말로 번역하면 틀에 박힌 방식이라는 뜻이다.

2. @Service, @Repository, @Controller 어노테이션을 추가하면,
빈에 등록되고 해당 layer에 부여된 어노테이션의 특수한 역할을 추가할 수 있다. 그리고 AOP를 사용할때 좋다고 한다.
@Component 어노테이션은 위의 3가지 어노테이션의 공통적인 기능을 가지고 있다.
*/

/*
 [스프링 MVC layer]
1. presentation layer (@Controller 사용)
  - 사용자의 요청을 받고 해당 요청에 대한 요구사항을 Service layer를 통해 받아서 사용자에게 건내주는 역할을 한다.
2. Service layer (@Service 사용)
  - 비즈니스 로직을 처리하는 역할을 한다. 예를들어 시청 인원수를 올린다던가, 결제를 처리한다던가 하는 역할을 한다.
  - Service layer가 필요한 이유는 관심사를 분리해서 유지보수를 편하게 할 수 있기 위해서다.
3. persistance layer (@Repository 사용)
  - 데이터를 저장하고 삭제하고 수정하는등의 역할을 한다.
 */


@Repository
public class UserRepository {

  @Autowired
  private SqlSession sqlSession;

  public void insertUserData(UserDto userDto) {
    sqlSession.insert(UserRepositoryNameSpace + "insertUserData", userDto);
  }

  public String selectUserForConfirmPassword(UserDto userDto) {
    return sqlSession.selectOne(UserRepositoryNameSpace + "selectPassword", userDto.getUserId());
  }
}
