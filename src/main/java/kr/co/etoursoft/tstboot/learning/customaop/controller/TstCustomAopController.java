package kr.co.etoursoft.tstboot.learning.customaop.controller;

import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import kr.co.etoursoft.tstboot.learning.BaseController;
import kr.co.etoursoft.tstboot.learning.customaop.TstCustomAopMethodAnnotation;
import kr.co.etoursoft.tstboot.pay.common.vo.PayApiResponse;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping(value = "/learning/customaop")
public class TstCustomAopController extends BaseController {

	@TstCustomAopMethodAnnotation
    @RequestMapping(value = "/testAop", method = { RequestMethod.POST }, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PayApiResponse> testAop(HttpEntity<String> httpEntity, 
    		@RequestHeader Map<String, Object> requestHeader) throws Exception {
    	
    	log.info("### /learning/customaop/testAop - Controller Process - Start!!!");
    	
    	Map<String, Object> reqMap = getReqMap(httpEntity);
    	reqMap.put("result", "SUCCESS");
    	
    	log.info("### /learning/customaop/testAop - Controller Process - End!!!");
    	
    	return new ResponseEntity<PayApiResponse>(PayApiResponse.of(
    			reqMap), HttpStatus.OK);
    }
    
}
