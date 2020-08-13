package com.youngsuk.bookstore.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisPassword;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/*
[@EnableRedisHttpSession 공부 내용]
이 어노테이션은 springSessionRepositoryFilter 이라는 빈을 생성시킨다.
    이 필터는 HttpSession의 구현체를 Redis로 변경한다.
*/


@EnableRedisHttpSession
@Configuration
public class RedisConfiguration {

  /*[@Value 공부 내용]
  1. properties 파일에 있는 데이터들을 선언한 변수안에 넣어서 샤용할 수 있게 해준다.
  설정값을 따로 관리하고 싶을때 사용하면 좋다.

  2. @PropertySource 어노테이션을 활용해서 해당 설정 파일의 경로를 명시해야 사용할 수 있다.
  application.properties에 있는 설정 값은 @PropertySource를 사용하지 않아도 @Value 통해 외부 데이터를 주입 받을 수 있다
  */

  /*
  [설정 정보를 외부에 두는게 좋은 이유]
  1. 외부 설정은 jar 파일로 만들때 컴파일 되지 않는다.
  그렇기 때문에 자주 바뀌는 데이터의 외부주입을 통해 컴파일을 다시 하는일이 없게 할 수 있다.

  2. ip, 암호같은 중요한 정보는 해커를 통해 유출될 수 있기 때문에 외부 설정 파일로 빼는게 좋다.
  */

  @Value("${spring.redis.host}")
  private String redisHostName;

  @Value("${spring.redis.password}")
  private String redisPassword;

  @Value("${spring.redis.port}")
  private int redisPort;

  @Bean
  public RedisConnectionFactory lettuceConnectionFactory() {
    RedisStandaloneConfiguration redisStandaloneConfiguration =
        new RedisStandaloneConfiguration(redisHostName, redisPort);
    redisStandaloneConfiguration.setPassword(RedisPassword.of(redisPassword));
    return new LettuceConnectionFactory(redisStandaloneConfiguration);
    }


}
