package kr.co.etoursoft.tstboot.learning.aop.service;

import org.json.JSONObject;
import org.springframework.stereotype.Service;

import kr.co.etoursoft.tstboot.learning.aop.vo.TstAopReqVo;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class TstAopServiceImpl implements TstAopService {

	@Override
	public JSONObject testMethod(TstAopReqVo reqVo) throws Exception {
		log.info("TstAopService.testMethod_" + reqVo.getOrderId() + "-Service-Start");
		
		log.info("TstAopService.testMethod_" + reqVo.getOrderId() + "-Service-End");
		return null;
	}

}
