package kr.co.etoursoft.tstboot.learning.aop.service;

import org.json.JSONObject;

import kr.co.etoursoft.tstboot.learning.aop.vo.TstAopReqVo;

public interface TstAopService {
	
    public JSONObject testMethod(TstAopReqVo reqVo) throws Exception;

}
