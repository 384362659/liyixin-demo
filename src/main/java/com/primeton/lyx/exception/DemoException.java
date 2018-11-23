package com.primeton.lyx.exception;

import com.primeton.lyx.enums.CustomEnum;

/**
 * 自定义异常
 * @author 李一新 
 *
 */
public class DemoException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * code 是异常码  message是异常信息
	 */
	private String code;
	private String msg;
	public DemoException(CustomEnum e) {
		setCode(e.getCode());
		setMsg(e.getMsg());
	}
	public DemoException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DemoException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
		// TODO Auto-generated constructor stub
	}

	public DemoException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	public DemoException(String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public DemoException(Throwable arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
}
