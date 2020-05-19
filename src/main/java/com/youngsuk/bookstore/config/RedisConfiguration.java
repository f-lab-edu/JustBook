package com.youngsuk.bookstore.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisPassword;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;


/***
 * [세션 공부]
 * 세션이란 일반적으로 로그인을 할때 사용되는 기술이다.
 * 쿠키와 세션이 많이 비교가 되는데, 쿠키는 클라이언트에 저장되고 세션은 서버에 저장된다.
 * 웹 컨테이너는 웹브라우저 하나마다 세션을 생성한다.
 * 생성된 세션은 웹브라우저의 쿠키에 저장된다.
 * 웹서버는 웹브라우저의 쿠키를 통해서 사용자의 로그인을 유지 할 수 있다.
 * 세션에는 유효 기간 설정을 해줘야 한다. 왜냐면 사용자가 많이 들어와서
 * 세션 객체가 계속 생성된다면 메모리가 부족해질 수 있기 때문이다
 *
 *
 * [서블릿 필터 공부 내용]
 * 사용자에게 들어온 요청이 서블릿으로 바로 가게 하지 않고 필터를 통해서 갈 수 있도록 한다.
 * 필터는 사용자에게 전달받은 쿠키에 세션이 있는지 확인하는 방법으로 사용할수있다.
 *
 * [@EnableRedisHttpSession 공부 내용]
 * 이 어노테이션은 springSessionRepositoryFilter 이라는 빈을 생성시킨다.
 * 이 필터는 HttpSession의 구현체를 Redis로 변경한다.
 *
 * (@EnableRedisHttpSession 스프링 공홈 자료)
 * https://docs.spring.io/spring-session/docs/current/reference/html5/guides/java-redis.html
 */
@EnableRedisHttpSession
@Configuration
public class RedisConfiguration {
    /***
     * [@Value 공부 내용]
     * properties 파일에 있는 데이터들을 선언한 변수안에 넣어서 샤용할 수 있게 해준다.
     * 설정값을 따로 관리하고 싶을때 사용하면 좋다.
     * @PropertySource 어노테이션을 활용해서 해당 설정 파일의 경로를 명시해줘야지 사용할 수 있다.
     *
     * [설정 정보를 외부에 두는게 좋은 이유]
     * ip, 암호같은 중요한 정보가 유출될 수 있기 때문에 외부 설정 파일로 빼는게 좋다.
     * 환경에 따라 rdbms나 nosql과 같은 프로그램들의 설정이 달라질 수 있기 때문에 설정 정보를 한꺼번에 변경할 수 있도록 설정 정보를 외부에 두는게 좋다
     */
    @Value("${spring.redis.host}")
    private String redisHostName;

    @Value("${spring.redis.password}")
    private String redisPassword;

    @Value("${spring.redis.port}")
    private int redisPort;


    /***
     * [lettuce 선정 이유]
     * 스프링 개발자를 포함한 대부분의 커뮤니티 사용자들이 lettuce를 선호해서 사용했다.
     * 하지만 jedis & lettuce & redisson 등의 redis client 중 어떤것이 더 좋은지 명확하게 알기 위해서 테스트를 할것이다.
     */
    @Bean
    public RedisConnectionFactory lettuceConnectionFactory(){
        RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration(redisHostName,redisPort);
        redisStandaloneConfiguration.setPassword(RedisPassword.of(redisPassword));
        LettuceConnectionFactory lettuceConnectionFactory = new LettuceConnectionFactory(redisStandaloneConfiguration);
        return lettuceConnectionFactory;
    }


}
