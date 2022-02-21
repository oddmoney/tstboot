package kr.co.etoursoft.tstboot.pay.common.controller;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;

import com.fasterxml.jackson.databind.ObjectMapper;

import kr.co.etoursoft.tstboot.pay.common.exception.PayException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BaseRestController {

	@Autowired
    protected ObjectMapper baseObjectMapper;
	
	private Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

	protected <T> T getReqObject(HttpEntity<String> param, Class<T> targetClass) throws Exception {
    	try {
	    	if (param != null && param.hasBody()) return baseObjectMapper.readValue(
	    			param.getBody(), baseObjectMapper.getTypeFactory().constructType(targetClass));
        } catch (IllegalArgumentException e) {
        	log.error("[buildResponse]ObjectMapper ConvertValue IllegalArgumentException:::{}", e);
            throw new PayException("1001", "ObjectMapper ConvertValue IllegalArgumentException");
        } catch (Exception e) {
        	log.error("[buildResponse]ObjectMapper ConvertValue Exception:::{}", e);
        	throw new PayException("1001", "ObjectMapper ConvertValue Exception");
        }
        return null;
    }
	
	protected void validateVo(Object vo) throws PayException {
    	Set<ConstraintViolation<Object>> valObj = validator.validate(vo);
        if (!valObj.isEmpty()) {
        	try {
				log.error("Validator-VO-Vlidation-Check:{}", valObj.toString());
			} catch (Exception e) { 
				log.error("Validator-VO-Vlidation-Check-Exception:{}", e);
			}
        	throw new PayException("1002");
        }
	}

}
