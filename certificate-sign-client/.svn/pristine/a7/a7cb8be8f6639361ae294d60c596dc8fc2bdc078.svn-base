package com.ule.cerclient.exception;

/**
 * 
 * @author jjiang
 *
 */
public class CerSignException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8769738409395754945L;

	private String code = "";
	private String message = "";

	public CerSignException(final String code, String message) {
		super();
		this.code = code;
		this.message = message;
	}

	public CerSignException(final String code, String message,
			final Throwable throwable) {
		super(throwable);
		this.code = code;
		this.message = message;
	}

	public String getLocalMessage() {
		return this.message;
	}

	@Override
	public String getMessage() {
		return this.message + " [" + this.code + "]";
	}

	public String getCode() {
		return this.code;
	}

}
