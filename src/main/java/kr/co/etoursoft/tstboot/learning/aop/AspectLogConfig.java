package kr.co.etoursoft.tstboot.learning.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

/*
 * @Aspect
 * AOP 를 사용 (AOP는 관점 지향 프로그래밍으로 핵심 비즈니스 기능과 공통 기능으로 구분하고, 공통 기능을 개발자의 코드 밖에서 필요한 시점에 적용하는 프로그래밍 방법으로, 메서드를 가로채서 앞이나 뒤에 필요한 공통로직을 적용)
 * Dependency :
 * 		<groupId>org.aspectj</groupId> <artifactId>aspectjrt</artifactId>
 * 		<groupId>org.aspectj</groupId> <artifactId>aspectjweaver</artifactId>
 */
@Aspect
@Component
/*
 * @Slf4j : 로깅에 대한 추상 레이어를 제공하는 인터페이스의 모음
 * Dependency :
 * 		<groupId>org.projectlombok</groupId>
 * 		<artifactId>lombok</artifactId>
 * 		<optional>true</optional> 
 */
@Slf4j
public class AspectLogConfig {

	/*
	 * kr.co.etoursoft.tstboot.pay 패키지와 하위 패키지의 Controller 로 끝나는 클래스, 리턴타입이 있거나 없는 모든 메소드 실행
	 */
    @Before("execution(* kr.co.etoursoft.tstboot.learning.aop..*.*Controller.*(..))")
    public void doControllerBefore() {
        log.info("===== AspectLog Test : Controller Before =====");
    }
    @After("execution(* kr.co.etoursoft.tstboot.learning.aop..*.*Controller.*(..))")
    public void doControllerAfter() {
    	log.info("===== AspectLog Test : Controller After =====");
    }
    
	/*
	 * kr.co.etoursoft.tstboot.pay 패키지와 하위 패키지의 ServiceImpl 로 끝나는 클래스, 리턴타입이 있거나 없는 모든 메소드 실행
	 */
    @Before("execution(* kr.co.etoursoft.tstboot.learning.aop..*.*ServiceImpl.*(..))")
    public void doServiceBefore() {
        log.info("===== AspectLog Test : Service Before =====");
    }
    @After("execution(* kr.co.etoursoft.tstboot.learning.aop..*.*ServiceImpl.*(..))")
    public void doServiceAfter() {
    	log.info("===== AspectLog Test : Service After =====");
    }

}
