package kr.co.etoursoft.tstboot.pay.common.vo;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import kr.co.etoursoft.tstboot.pay.common.exception.PayException;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Builder
@Getter
@Setter
@ToString
public class PayApiResponse {
    @Builder.Default
    private String code = "0000";
    @Builder.Default
    private String message = "SUCCESS";
    @JsonInclude(value = Include.NON_NULL)
    private Object data;
    
    public static PayApiResponse of(String code, String message, Object data) {
        return PayApiResponse.builder()
                .code(StringUtils.defaultIfBlank(code, "9999"))
                .message(message)
                .data(data)
                .build();
    }
    
    public static PayApiResponse of(Object data) {
    	if (data instanceof PayException) {
    		PayException e = (PayException) data;
    		return PayApiResponse.builder()
                    .code(StringUtils.defaultIfBlank(e.getCode(), "9999"))
                    .message(e.getMessage())
                    .build();
    	}
    	
        return PayApiResponse.builder()
                .data(data)
                .build();
    }
    
}
