package kr.co.etoursoft.tstboot.learning.cache;

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
import kr.co.etoursoft.tstboot.pay.common.vo.PayApiResponse;

@RestController
@RequestMapping(value = "/learning/cache")
public class TstCacheController extends BaseController {

	@Autowired
	CacheTest cacheTest;
	
    @RequestMapping(value = "/getCache", method = { RequestMethod.POST }, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PayApiResponse> getCache(HttpEntity<String> httpEntity, 
    		@RequestHeader Map<String, Object> requestHeader) throws Exception {
    	
    	return new ResponseEntity<PayApiResponse>(PayApiResponse.of(
    			cacheTest.getCacheData(getReqMap(httpEntity).get("testVal").toString())), 
    			HttpStatus.OK);
    }
    
    @RequestMapping(value = "/removeCache", method = { RequestMethod.POST }, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PayApiResponse> removeCache(HttpEntity<String> httpEntity, 
    		@RequestHeader Map<String, Object> requestHeader) throws Exception {
    	
    	return new ResponseEntity<PayApiResponse>(PayApiResponse.of(
    			cacheTest.removeCacheData(getReqMap(httpEntity).get("testVal").toString())), 
    			HttpStatus.OK);
    }
    
    @RequestMapping(value = "/removeAllCache", method = { RequestMethod.POST }, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PayApiResponse> removeAllCache(HttpEntity<String> httpEntity, 
    		@RequestHeader Map<String, Object> requestHeader) throws Exception {

    	return new ResponseEntity<PayApiResponse>(PayApiResponse.of(
    			cacheTest.removeAllCacheData()), HttpStatus.OK);
    }


    
    
    @RequestMapping(value = "/getObjCache", method = { RequestMethod.POST }, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PayApiResponse> getMapCache(HttpEntity<String> httpEntity, 
    		@RequestHeader Map<String, Object> requestHeader) throws Exception {
    	
    	return new ResponseEntity<PayApiResponse>(PayApiResponse.of(
    			cacheTest.getMapCacheData(getReqObj(httpEntity, CacheTestVo.class))), 
    			HttpStatus.OK);
    }
    
}
