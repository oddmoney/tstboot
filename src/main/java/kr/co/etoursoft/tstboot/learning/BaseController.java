package kr.co.etoursoft.tstboot.learning;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;

import com.fasterxml.jackson.databind.ObjectMapper;

public class BaseController {

	@Autowired
    protected ObjectMapper baseObjectMapper;

    /**
     * 요청 값 HttpEntity 를 Map 으로 변환하여 리턴한다. 
     * @param httpEntity
     * @return Map<String, Object>
     * @throws Exception
     */
	protected Map<String, Object> getReqMap(HttpEntity<String> httpEntity) throws Exception {
    	return baseObjectMapper.readValue(httpEntity.getBody(), 
    			baseObjectMapper.getTypeFactory().constructType(Map.class));
    }
    /**
     * 요청 값 HttpEntity 를 Map 으로 변환하여 리턴한다. 
     * @param httpEntity
     * @return Map<String, Object>
     * @throws Exception
     */
	protected <T> T getReqObj(HttpEntity<String> httpEntity, Class<T> targetClass) throws Exception {
    	return baseObjectMapper.readValue(httpEntity.getBody(), 
    			baseObjectMapper.getTypeFactory().constructType(targetClass));
    }
}
