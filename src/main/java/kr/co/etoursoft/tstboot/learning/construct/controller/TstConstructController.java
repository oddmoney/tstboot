package kr.co.etoursoft.tstboot.learning.construct.controller;

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
import kr.co.etoursoft.tstboot.learning.construct.adaptor.TstAdaptor;
import kr.co.etoursoft.tstboot.pay.common.vo.PayApiResponse;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping(value = "/learning/construct")
public class TstConstructController extends BaseController {

	@Autowired
	private TstAdaptor tstAdaptor;
	
    @RequestMapping(value = "/testConstruct", method = { RequestMethod.POST }, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PayApiResponse> testConstruct(HttpEntity<String> httpEntity, 
    		@RequestHeader Map<String, Object> requestHeader) throws Exception {
    	
    	log.info("### /learning/construct/testConstruct - Controller Process - Start!!!");
    	
    	Map<String, Object> reqMap = getReqMap(httpEntity);

    	ResponseEntity<PayApiResponse> resObj = new ResponseEntity<>(PayApiResponse.of(
    			tstAdaptor.getPayType(reqMap)), HttpStatus.OK);
    	
    	log.info("### /learning/construct/testConstruct - Controller Process - End!!!");
    	return resObj;
    }
    
}
