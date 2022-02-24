package kr.co.etoursoft.tstboot;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@ActiveProfiles("${spring.profiles.active}")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
@Slf4j
class TstbootApplicationTests {

	@Autowired
    private MockMvc mockMvc;
	
	@Autowired
    protected ObjectMapper baseObjectMapper;

	@Test
	public void testAop() throws Exception {
		Map<String, Object> params = new HashMap<>();
		params.put("orderId", "AA12345");

		// perform : Request를 테스트 한다.
		// post : POST 방식을 정의
		// get : GET 방식을 정의
		//  EX1: get("/account")
		//	EX2: get("/account/{idx}", 1)
		// content : RequestBody의 컨텐츠를 정의하며, String외 Byte[] 도 지원한다.
		// contentType : RequestBody의 Type을 정의한다. String외 MediaType도 지원한다.
		// characterEncoding : 해당 요청의 문자열 인코딩을 정의한다.
		// accept : 응답처리 Type 을 정의한다. String외 MediaType도 지원한다.
		// header : 요청 헤더를 정의한다.
		// headers : 여러 요청 헤더들을 HttpHeaders 를 통해서 정의한다.
		mockMvc.perform(post("/learning/aop/testAop").content(
				baseObjectMapper.writeValueAsString(params))
				.contentType(MediaType.APPLICATION_JSON)
				.characterEncoding("UTF-8")
				.accept(MediaType.APPLICATION_JSON)
		)
		// andDo : 해당 요청 및 응답을 처리하며, 콘솔창 출력이 가능하다
		// print() : 요청 및 응답에 대한 메시지를 콘솔에 출력한다. OutputStream, Writer와 같은 출력 대상을 적용할 수 있다.
		.andDo(print())
		// andExpect : 해당 요청 및 응답의 검증을 진행할 수 있다
		// status() : 응답에 대한 HttpStatus를 검증을 할 수 있다. is() 메소드를 활용하여 HttpStatus code를 입력할 수 있다.
		//	EX1: .andExpect(status().isOk())
		//	EX2: .andExpect(status().is(200))
		.andExpect(status().isOk());
	}
	
	@Test
	public void testConstruct() throws Exception {
		Map<String, Object> params = new HashMap<>();
		params.put("payTypeDetailCd", "KF1");
		//params.put("payTypeCd", "KF");

		MvcResult result = mockMvc.perform(post("/learning/construct/testConstruct").content(
				baseObjectMapper.writeValueAsString(params))
				.contentType(MediaType.APPLICATION_JSON)
				.characterEncoding("UTF-8")
				.accept(MediaType.APPLICATION_JSON)
		)
		.andDo(print())
		.andExpect(status().isOk())
		.andReturn();
		
		log.info("\n#####testConstruct-result.getResponse():{}", result.getResponse().getContentAsString());
	}

	@Test
	public void testConstruct2() throws Exception {
		Map<String, Object> params = new HashMap<>();
		//params.put("payTypeDetailCd", "KF1");
		params.put("payTypeCd", "KF");

		mockMvc.perform(post("/learning/construct/testConstruct").content(
				baseObjectMapper.writeValueAsString(params))
				.contentType(MediaType.APPLICATION_JSON)
				.characterEncoding("UTF-8")
				.accept(MediaType.APPLICATION_JSON)
		)
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(result -> {
			MockHttpServletResponse response = result.getResponse();
			log.info("\n#####testConstruct2-result.getResponse():{}", response.getContentAsString());			
		});
		
		
	}

}
