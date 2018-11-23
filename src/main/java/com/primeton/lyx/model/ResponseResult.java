package com.primeton.lyx.model;

import com.primeton.lyx.exception.DemoException;

public class ResponseResult<T> {
	/**
	 * 方便于响应的类
	 */
	public Integer state;
	public T data;
	private String code;
	private String message;
	public static final int STATE_OK=1;
	public static final int STATE_ERR=0;
	public ResponseResult() {
		super();
	}
	public ResponseResult(Integer state) {
		super();
		setState(state);
	}
	public ResponseResult(DemoException e) {
		setState(ResponseResult.STATE_ERR);
		setCode(e.getCode());
		setMessage(e.getMsg());
	}
	public ResponseResult(Integer state, T data) {
		setState(state);
		setData(data);
	}
	public ResponseResult(Integer state,String message) {
		super();
		setState(state);
		setMessage(message);
	}
	public ResponseResult(Integer state, T data, String message) {
		super();
		setState(state);
		setMessage(message);
		setData(data);
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "ResponseResult [state=" + state + ", data=" + data + ", code=" + code + ", message=" + message + "]";
	}
	
	
}
