package kr.co.etoursoft.tstboot.pay.controller;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import kr.co.etoursoft.tstboot.pay.common.controller.BaseRestController;
import kr.co.etoursoft.tstboot.pay.common.vo.PayApiResponse;
import kr.co.etoursoft.tstboot.pay.service.appr.ApprovalService;
import kr.co.etoursoft.tstboot.pay.vo.appr.SaveApprovalReqVo;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value = "/pay/appr")

/*
 * @Slf4j : 로깅에 대한 추상 레이어를 제공하는 인터페이스의 모음
 * Dependency :
 * 		<groupId>org.projectlombok</groupId>
 * 		<artifactId>lombok</artifactId>
 * 		<optional>true</optional> 
 */
@Slf4j
public class ApprovalController extends BaseRestController{

	@Autowired
	ApprovalService approvalService;
	
    /**
     * <pre>
     * 온라인 승인정보 저장요청을 처리한다.
     * </pre>
     * @param HttpEntity<String> 
     * @return ResponseEntity<BeApiResponse>
     * @throws Exception
     */
    @RequestMapping(value = "/saveApproval/v1.0", method = { RequestMethod.POST }, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PayApiResponse> savePaymentApproval(HttpEntity<String> httpEntity, 
    		@RequestHeader Map<String, Object> requestHeader) throws Exception {

    	// 요청 VO 생성
    	SaveApprovalReqVo reqVo = getReqObject(httpEntity, SaveApprovalReqVo.class);
    	
    	// 요청 VO 로깅
    	if (reqVo != null && StringUtils.isNotBlank(reqVo.getOrderId())) {
    		log.info("savePaymentApproval_" + reqVo.getOrderId() + ":{}", reqVo);
    	}

		// 요청 VO Validation
    	validateVo(reqVo);

    	// Business 처리
    	return new ResponseEntity<PayApiResponse>(PayApiResponse.of(
    			approvalService.saveApproval(reqVo)), HttpStatus.OK);
    }
    
}
