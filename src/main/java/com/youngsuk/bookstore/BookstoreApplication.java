package com.youngsuk.bookstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/*
<aop:aspectj-autoproxy> xml 설정과 같은 기능을 하는 어노테이션이다.
spring bean이 하나 이상의 aspect로 advice 되는것을 스프링이 결정한다.
해당 bean의 메소드 호출을 가로채고 필요할때 advice를 실행할 수 있도록 자동으로 proxy를 생성한다.
 */
@EnableAspectJAutoProxy
@EnableCaching
@SpringBootApplication
public class BookstoreApplication {
  public static void main(String[] args) {
    SpringApplication.run(BookstoreApplication.class, args);
    }
}
