package kr.co.etoursoft.tstboot.pay.service.appr;

import org.json.JSONObject;
import org.springframework.stereotype.Service;

import kr.co.etoursoft.tstboot.pay.vo.appr.SaveApprovalReqVo;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ApprovalServiceImpl implements ApprovalService {

	@Override
	public JSONObject saveApproval(SaveApprovalReqVo reqVo) throws Exception {
		log.info("saveApproval_" + reqVo.getOrderId() + "-Service-Start");
		
		log.info("saveApproval_" + reqVo.getOrderId() + "-Service-End");
		return null;
	}

}
