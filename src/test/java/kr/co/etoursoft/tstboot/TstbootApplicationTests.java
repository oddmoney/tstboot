package kr.co.etoursoft.tstboot;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import lombok.Getter;
import lombok.Setter;

@ActiveProfiles("${spring.profiles.active}")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
class TstbootApplicationTests {

	@Autowired
    private MockMvc mockMvc;
	
	@Test
	public void testList() throws Exception {
		mockMvc.perform(get("/hello"))
        .andExpect(status().isOk())
        .andDo(print());
	}
	
	
	@Getter
	@Setter
	static class SampleVo {
		private String stringVal;
	}

}
