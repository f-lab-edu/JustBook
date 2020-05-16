package com.youngsuk.bookstore.config;


import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.sql.DataSource;

/***
 * [@Configuration 공부내용]
 * 스프링에서 관리하는 빈들이 있는 클래스라는걸 알려주기 위한 어노테이션
 * @Configuration이 달린 클래스에 있는 빈들은 ioc 컨테이너에서 관리 되는 빈이 된다.
 */
@Configuration
public class MybatisConfiguration {

    /***
     * [@Atuowired 공부내용]
     *  @Autwired가 달려있는 ioc 컨테이너에 존재하는 빈을 해당 클래스에서 주입을 받아서 사용할 수 있게 해준다.
     *
     * [@Primary 공부내용]
     * 만약 interface에 @autowired 어노테이션을 걸었을 경우
     * 스프링은 interface를 구현한 여러개의 클래스중 어떤 클래스를 주입해줘야되는지 모르게 된다.
     * 이떄 내가 주입하고 싶은 클래스에 @primary 어노테이션을 추가하면 된다.
     *
     */
    @Autowired
    private ApplicationContext applicationContext;

    /***
     * [@Bean 공부내용]
     * 스프링 ioc 컨테이너가 관리하는 빈이 될 수 있도록 하는 어노테이션이다.
     * 메소드에 추가하는 어노테이션이고, 메소드 명이 빈의 id값, 타입은 빈의 타입, return에는 빈의 객체가 등록된다.
     */
    @Bean
    /***
     * [@ConfigurationProperties 공부내용]
     * 스프링 부트에서 사용할 수 있는 어노테이션이다.
     * 외부 설정 파일을 통해서 객체에 값을 등록할 수 있다.
     * 설정 값은 따로 외부 파일에 두는게 관리할때 편할것 같아서 있는것 같다.
     */
    @ConfigurationProperties(prefix = "spring.datasource.hikari")
    public HikariConfig hikariConfig() {
        return new HikariConfig();
    }

    @Bean
    public DataSource dataSource() {
        DataSource dataSource = new HikariDataSource(hikariConfig());
        return dataSource;
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setMapperLocations(applicationContext.getResources("classpath:/query/**/*.xml"));
        return sqlSessionFactoryBean.getObject();
    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}