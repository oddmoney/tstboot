package kr.co.etoursoft.tstboot.pay.common.exception;

public class PayException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	private String code;
	
	public PayException (String code, String message) {
		super(message);
		this.code = code;
	}

	public PayException (String code, String message, Throwable cause) {
		super(message, cause);
		this.code = code;
	}

	public PayException (String code, String message, Exception e) {
		super(message, e);
		this.code = code;
	}

	public PayException (String code, Exception e) {
		super(e);
		this.code = code;
	}

	public PayException (String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}

}
