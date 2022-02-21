package kr.co.etoursoft.tstboot.pay.vo.appr;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.json.JSONObject;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
@ToString
public class SaveApprovalReqVo {
    private String rescode;
    private String resmsg;
    
	@NotBlank @Size(max = 19)
    private String orderId;
	
    private JSONObject resData;
}
