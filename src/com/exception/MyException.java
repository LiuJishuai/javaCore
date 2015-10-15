package com.exception;
/**
 *
 * @Message:  created by Liujishuai on 2015年10月10日
 * 
 * @Description: 自定义异常
 */
public class MyException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public MyException(String message) {
		super(message,new Throwable(message));
	}

	public MyException(Throwable cause) {
		super(cause);
	}

	public MyException(String message, Throwable cause) {
		super(message, cause);
	}
}

