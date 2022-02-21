package kr.co.etoursoft.tstboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;

/*
 * @SpringBootApplication : 스프링 부트의 동작에서 가장 핵심적인 어노테이션으로 3가지의 annotation을 하나로 적용함 (@Configuration, @EnableAutoConfiguration, @ComponentScan)
 * 스프링부트는 빈을 2번 등록함. 
 * 1) @ComponentScan 컴포넌트 스캔으로 등록.
 * 2) @EnableAutoConfiguration을 통해 Configuration 설정 파일을 자동으로 읽어들여 Bean을 등록.
 * Dependency : 
 * 		<groupId>org.springframework.boot</groupId>
 * 		<artifactId>spring-boot-starter-web</artifactId>
 */
@SpringBootApplication

/*
 * @EnableCaching : cache를 사용하겠다는 Annotaion!
 * Dependency : 
 * 		<groupId>org.springframework.boot</groupId> 
 * 		<artifactId>spring-boot-starter-web</artifactId>
 */
@EnableCaching 

/*
 * @ComponentScan : @Configuration, @Controller, @RestController, @Repository, @Service 어노테이션을 사용하는 객체를 스캔하여 초기화 후 로드
 * 		value = 스캔할 base package (설정하지 않으면 @SpringBootApplication 이 정의된 클래스가 위치한 패키지가 base package 가 됨)
 * Dependency :
 * 		<groupId>org.springframework.boot</groupId>
 * 		<artifactId>spring-boot-starter-web</artifactId>
 */
@ComponentScan(value = { "kr.co.etoursoft.tstboot.*" })

/*
 * @PropertySource : 프로퍼티 파일을 로드
 * Dependency :
 * 		<groupId>org.springframework.boot</groupId>
 * 		<artifactId>spring-boot-starter-web</artifactId>
 */
@PropertySource({ "classpath:property/pay-${spring.profiles.active}.properties"})

/*
 * @EnableAspectJAutoProxy
 * AOP 를 사용할 수 있도록 해주는 어노테이션
 * (AOP는 관점 지향 프로그래밍으로 핵심 비즈니스 기능과 공통 기능으로 구분하고, 공통 기능을 개발자의 코드 밖에서 필요한 시점에 적용하는 프로그래밍 방법으로, 메서드를 가로채서 앞이나 뒤에 필요한 공통로직을 적용)
 * Dependency :
 * 		<groupId>org.aspectj</groupId> <artifactId>aspectjrt</artifactId>
 * 		<groupId>org.aspectj</groupId> <artifactId>aspectjweaver</artifactId>
 */
@EnableAspectJAutoProxy
class TstbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(TstbootApplication.class, args);
	}

}
