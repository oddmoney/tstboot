package kr.co.etoursoft.tstboot.pay.common.exception;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import kr.co.etoursoft.tstboot.pay.common.vo.PayApiResponse;
import lombok.extern.slf4j.Slf4j;

@RestController
@ControllerAdvice
@Slf4j
public class PayExceptionHandler {

    @ExceptionHandler({PayException.class})
    protected ResponseEntity<PayApiResponse> handlePayException(PayException e) {
    	String errCd = e.getCode();
    	String errMsg = e.getMessage();
    	
    	if (StringUtils.isBlank(errMsg)) errMsg = "Unknown Error";

    	log.error("PayExceptionHandler-handlePayException-[errCd:{}, errMsg:{}", errCd, errMsg);
    	
    	return new ResponseEntity<PayApiResponse>(PayApiResponse.of(
    			errCd, errMsg, null), HttpStatus.OK);
    }

    @ExceptionHandler({Exception.class})
    protected ResponseEntity<PayApiResponse> handleException(Exception e) {
    	// Skypay 에러 정의
    	String errCd = "9999";
    	String errMsg = e.getMessage();
    	
    	if (StringUtils.isBlank(errMsg)) errMsg = "System Error";

    	log.error("PayExceptionHandler-handleException-[errCd:{}, errMsg:{}", errCd, errMsg);
    	
    	return new ResponseEntity<PayApiResponse>(PayApiResponse.of(
    			errCd, errMsg, null), HttpStatus.OK);
    }

}
