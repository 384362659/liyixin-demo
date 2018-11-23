package com.primeton.lyx.enums;
/**
 * 自定义异常枚举类
 * @author 李一新
 *
 */
public enum CustomEnum {
	ERROR_FORMATNAME("00001", "用户名格式有误"),ERROR_FORMATPASSWORD("00002", "密码格式有误"),
	ERROR_REPEATNAME("00003", "用户名已被注册"),ERROR_NOTHAVA("00004", "用户不存在"),
	ERROR_MATCHPASSWORD("00005", "原密码不匹配"),ERROR_NOTNAME("00006", "用户名不存在"),
	ERROR_PASSWORDBUG("00007", "密码错误"),ERROR_NULLDEPARTMENT("00008", "部门号和部门名称不能为空"),
	ERROR_HAVEDEPARTMENT("00009", "部门已经被注册"),ERROR_NULLDEPARTMENTCODE("00010", "部门号不能为空"),
	ERROT_NULLORG("00011", "没有这个部门"),ERROR_CHANGE("00012", "更新失败"),
	ERROR_DELETE("00013", "删除失败有下级部门或者部门有员工");


	private String code;

	private String msg;

	CustomEnum(String code, String msg) {
		this.code = code;
		this.msg = msg;
	}
	public String getCode() {
		return code;
	}
	public String getMsg() {
		return msg;
	}
}
