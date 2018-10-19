package com.example.demo.common;

import java.io.Serializable;
/**
 *  统一返回对象
 * @author YCKJ1060
 *
 * @param <T>
 */
public class Result<T extends Object> implements Serializable {
	
	private static final long serialVersionUID = 1L;
	/**
	 * 成功code
	 */
	private final static String SUCESS_CODE="00000000";
	/**
	 * 成功描述
	 */
	private final static String SUCESS_MSG="成功";
	
	/**
	 * 返回码
	 */
	private String code;
	
	/**
	 * 返回结果描述
	 */
	private String message;
	
	/**
	 * 成功标志
	 */
	private Boolean sucess;
	/**
	 * 返沪结果
	 */
	private T data;
	
	private Result() {
		
	}
	
	private Result(String code, String message,T t,Boolean sucess) {
		this.code = code;
		this.message = message;
		this.data= t ;
		this.sucess = sucess;
	}
	
	private Result(T t) {
		this.code = SUCESS_CODE;
		this.message = SUCESS_MSG;
		this.data = t;
		this.sucess = true;
	}
	
	/**
	 * 错误返回
	 * @param code  
	 * @param message
	 * @return
	 */
	public static <T> Result<T> fail(String code, String message) {
		return new Result<T>(code,message,null,false);
	}
	/**
	 * 成功返回
	 * @param t
	 * @return
	 */
	public static <T> Result<T> sucess(T t){
		return new Result<T>(t);
	}

	public String getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

	public T getData() {
		return data;
	}
	
	public Boolean getSucess() {
		return sucess;
	}
}
