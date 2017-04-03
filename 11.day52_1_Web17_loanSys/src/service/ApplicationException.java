package service;

public class ApplicationException extends Exception {
	/**
	 * when you have some many of exceptions
	 * you can define an exception with different errorCode,
	 * thus, you can encapsulate all these different errors to 
	 * just one exception object
	 */

	private String errorCode;

	public ApplicationException(String errorCode) {
		super();
		this.errorCode = errorCode;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	
}
