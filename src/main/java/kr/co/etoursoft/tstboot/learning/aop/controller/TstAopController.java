package kr.co.etoursoft.tstboot.learning.aop.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import kr.co.etoursoft.tstboot.learning.BaseController;
import kr.co.etoursoft.tstboot.learning.aop.service.TstAopService;
import kr.co.etoursoft.tstboot.learning.aop.vo.TstAopReqVo;
import kr.co.etoursoft.tstboot.pay.common.vo.PayApiResponse;

@RestController
@RequestMapping(value = "/learning/aop")
public class TstAopController extends BaseController {

	@Autowired
	TstAopService tstAopService;
	
    @RequestMapping(value = "/testAop", method = { RequestMethod.POST }, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PayApiResponse> testAop(HttpEntity<String> httpEntity, 
    		@RequestHeader Map<String, Object> requestHeader) throws Exception {
    	
    	return new ResponseEntity<PayApiResponse>(PayApiResponse.of(
    			tstAopService.testMethod(getReqObj(httpEntity, TstAopReqVo.class))), 
    			HttpStatus.OK);
    }
    
}
