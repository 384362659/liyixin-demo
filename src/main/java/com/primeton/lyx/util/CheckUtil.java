package com.primeton.lyx.util;
/**
 * 工具类
 * @author 李一新
 *
 */
public class CheckUtil {

	public CheckUtil() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * 验证用户名的正则表达式
	 */
	public static final String REGEX_USERNAME 
		= "^[a-zA-Z]{1}[a-zA-Z0-9_]{3,15}$";
	
	/**
	 * 验证密码的正则表达式
	 */
	public static final String REGEX_PASSWORD 
		= "^\\d{6,15}$";
	
	/**
	 * 验证用户名
	 * @param username 需要被验证格式的用户名
	 * @return 如果符合格式要求，则返回true，否则返回false
	 */
	public static boolean checkUsername(String name) {
		return name.matches(REGEX_USERNAME);
	}
	
	/**
	 * 验证密码
	 * @param password 需要被验证格式的密码
	 * @return 如果符合格式要求，则返回true，否则返回false
	 */
	public static boolean checkPassword(String password) {
		return password.matches(REGEX_PASSWORD);
	}
	
}
