package com.haotiben.feedback.Exception;

import org.apache.log4j.Logger;

import com.haotiben.feedback.common.Resource;
import com.haotiben.feedback.model.ErrorMessage;

/**
 * 业务逻辑层异常
 *
 * @author shifeng
 */
public class BOException extends Exception {
	private static Logger log = Logger.getLogger(BOException.class);
	private static final long serialVersionUID = 3044709281312856248L;
	private ErrorMessage errorMessage;

	public BOException() {
		super();
	}

	/**
	 * @param string
	 */
	public BOException(String errorCode,String request) {
		errorMessage = new ErrorMessage();
		errorMessage.setErrorCode(errorCode);
		errorMessage.setRequest(request);
		String error = Resource.getString(errorCode);
		errorMessage.setError(error);
		setBOException(error, errorMessage);
	}

	/**
	 * @param string
	 *            ErrorMessage
	 */
	public void setBOException(String message, ErrorMessage errorMessage) {
		log.info(message);
		this.errorMessage = errorMessage;
	}

	public ErrorMessage getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(ErrorMessage errorMessage) {
		this.errorMessage = errorMessage;
	}

}
