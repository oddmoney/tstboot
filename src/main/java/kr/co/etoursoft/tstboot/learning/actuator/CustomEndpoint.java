package kr.co.etoursoft.tstboot.learning.actuator;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
/*
 * Custom Actuator : application.yml 에서 해당 Custom Endpoint 를 지정할 수 있음 
 * health 체크와 같이 부라우저 또는 post 방식을 이용하여 호출할 수 있다
 */
@Endpoint(id="customEndpoint")
public class CustomEndpoint {
	
	@ReadOperation
	@Bean
	public Map<String, Object> testEndpoint() {
		Map<String, Object> resMap = new HashMap<>();
		resMap.put("name", "CUSTOM ENDPOINT");
		resMap.put("status", "ING...");
		return resMap;
	}

}
