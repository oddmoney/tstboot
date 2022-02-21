package kr.co.etoursoft.tstboot.learning.construct.adaptor;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kr.co.etoursoft.tstboot.pay.mapper.paytype.PayTypeMapper;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class TstAdaptor {

	@Autowired
	private PayTypeMapper payTypeMapper;
	
	private List<Map<String, Object>> payTypeList;
	
	public List<Map<String, Object>> getPayType(Map<String, Object> reqMap) throws Exception {
		log.info("###tstAdaptor-getPayType - reqMap : {}", reqMap);
		return payTypeList.stream().filter(m -> {
			boolean isMatch = true;
			for (String keyStr : reqMap.keySet()) {
				if (m.containsKey(keyStr)) {
					if (!m.get(keyStr).toString().equals(reqMap.get(keyStr).toString())) {
						isMatch = false;
					}
				}
			}
			return isMatch;
		}).collect(Collectors.toList());
	}

	/*
	 * PostConstruct : Spring 에서 초기화 시 자동으로 먼저 수행되도록 설정한다
	 */
	@PostConstruct
	private void postMethod() {
		log.info("###tstAdaptor-PostConstruct - payTypes Set - Start!!!");
		
		try {
			payTypeList = payTypeMapper.selectPayTypeList(null);
		} catch (Exception e) {
			log.error("###tstAdaptor-PostConstruct - Exception : {}", e);
		}
		
		log.info("###tstAdaptor-PostConstruct - payTypes Set - End!!!");
	}
	
	/*
	@PreDestroy
	private void destroyMethod() {
		log.info("###tstAdaptor-PostConstruct - payTypeList Clear!!!");
		payTypeList = null;
	}
	*/
	
}
