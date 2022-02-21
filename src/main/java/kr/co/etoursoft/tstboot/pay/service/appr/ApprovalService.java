package kr.co.etoursoft.tstboot.pay.service.appr;

import org.json.JSONObject;

import kr.co.etoursoft.tstboot.pay.vo.appr.SaveApprovalReqVo;

public interface ApprovalService {
	
    public JSONObject saveApproval(SaveApprovalReqVo reqVo) throws Exception;

}
