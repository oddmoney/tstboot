package kr.co.etoursoft.tstboot.learning.dependson;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
public class TstDependsOn {

	@Bean
	/*
	 * DependsOn : 해당 Bean 이 등록되기 전에 먼저 등록되어야 하는 Beans 을 설정한다.
	 */
	@DependsOn("onDependsThird")
	public void onDependsLast() throws Exception {
		log.info("###TstDependsOn-onDependsLast - Start!!!");
	}
	
	@Bean
	public void onDependsFirst() {
		log.info("###TstDependsOn-onDependsFirst - Start!!!");
	}
	
	@Bean
	@DependsOn("onDependsFirst")
	public void onDependsSecond() {
		log.info("###TstDependsOn-onDependsSecond - Start!!!");
	}
	
	@Bean
	@DependsOn("onDependsSecond")
	public void onDependsThird() {
		log.info("###TstDependsOn-onDependsThird - Start!!!");
	}
}
