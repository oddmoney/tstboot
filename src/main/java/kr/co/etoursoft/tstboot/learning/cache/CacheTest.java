package kr.co.etoursoft.tstboot.learning.cache;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class CacheTest {

	/*
	 * Cache 를 사용하여 거의 변하지 않는 데이터를 cache 에서 조회한다.
	 * 캐시명 = CACHE_001 , key = val , 파라미터(val)길이가 10보다 작을 때만 캐시를 사용
	 */
	@Cacheable(value = "CACHE_001", condition = "#val.length() < 10")
	public String getCacheData(String val) throws Exception {
		log.info("\n=====CacheTest.getCacheData-CACHE_001-val:{}", val);
		return val + "_TEST";
	}

	/*
	 * 캐시명 = CACHE_001 , key = reqVo.testVal , 파라미터(val)길이가 10보다 작을 때만 캐시를 사용
	 */
	@Cacheable(value = "CACHE_001", key = "#reqVo.testVal", condition = "#reqVo.testVal.length() < 10")
	public String getMapCacheData(CacheTestVo reqVo) throws Exception {
		log.info("\n=====CacheTest.getMapCacheData-CACHE_001-val:{}", reqVo.getTestVal());
		return reqVo.getTestVal() + "_TEST";
	}

	/*
	 * 캐시명 = CACHE_001 , key = val , 해당 캐시의 Key 제거
	 */
	@CacheEvict(value = "CACHE_001")
	public String removeCacheData(String val) throws Exception {
		log.info("\n=====CacheTest.removeCacheData-CACHE_001-val:{}", val);
		return val + "_TEST";
	}

	/*
	 * 캐시명 = CACHE_001 , 해당 캐시의 전체 Key 제거
	 */
	@CacheEvict(value = "CACHE_001", allEntries = true)
	public String removeAllCacheData() throws Exception {
		log.info("\n=====CacheTest.removeAllCacheData-CACHE_001");
		return null;
	}


}
