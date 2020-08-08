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
[세션 공부]
세션이란 일반적으로 로그인을 할때 사용되는 기술이다.
쿠키와 세션이 많이 비교가 되는데, 쿠키는 클라이언트에 저장되고 세션은 서버에 저장된다.
웹 컨테이너는 웹브라우저 하나마다 세션을 생성한다.
생성된 세션은 웹브라우저의 쿠키에 저장된다.
웹서버는 웹브라우저의 쿠키를 통해서 사용자의 로그인을 유지 할 수 있다.
세션에는 유효 기간 설정을 해줘야 한다. 왜냐면 사용자가 많이 들어와서
세션 객체가 계속 생성된다면 메모리가 부족해질 수 있기 때문이다
*/

/*
[서블릿 필터 공부 내용]
사용자에게 들어온 요청이 서블릿으로 바로 가게 하지 않고 필터를 통해서 갈 수 있도록 한다.
필터는 사용자에게 전달받은 쿠키에 세션이 있는지 확인하는 방법으로 사용할수있다.
*/

/*
[@EnableRedisHttpSession 공부 내용]
이 어노테이션은 springSessionRepositoryFilter 이라는 빈을 생성시킨다.
    이 필터는 HttpSession의 구현체를 Redis로 변경한다.
*/

/*
로그인한 사용자가 결제 페이지에 머무르는 시간이 가장 많을것이라고 생각했다.
사용자가 이사를해서 주소를 새로 입력하거나 핸드폰을 바꿔서 번호를 바꿀 수도 있기 때문이다.
결제를 할때도 시간이 걸릴것이라고 생각했다. 이런 시간들을 고려했을때 10분이면 적절할것이라고 생각했다.
 */
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 60 * 10)
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
    RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration(redisHostName, redisPort);
    redisStandaloneConfiguration.setPassword(RedisPassword.of(redisPassword));
    LettuceConnectionFactory lettuceConnectionFactory = new LettuceConnectionFactory(redisStandaloneConfiguration);
    return lettuceConnectionFactory;
    }


}
