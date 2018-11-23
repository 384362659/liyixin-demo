package com.primeton.lyx.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户实体类
 * @author 李一新
 *
 */

public class User implements Serializable{
	
	private static final long serialVersionUID = -6738638224075941320L;
/**
 * 用户id
 */
	private Integer id;
	/**
	 * 用户名
	 */
	private String  name;
	/**
	 * 用户密码
	 */
	private String password;
	/**
	 * 部门号
	 */
	private String departmentCode;
	/**
	 * 创建人
	 */
	private String createdUser;
	/**
	 * 创建时间
	 */
	private Date createdTime;
	/**
	 * 修改人
	 */
	private String modifiedUser;
	/**
	 * 修改时间
	 */
	private Date modifiedTime; 
	
	private String newPassword;
	private String oldPassword;
	public User() {
		super();
	}
	public User(String name,String password,String departmentCode) {
		this.setName(name);
		this.setPassword(password);
		this.setDepartmentCode(departmentCode);
	}
	public User(String name,String password,String departmentCode,Integer id) {
		this.setId(id);
		this.setName(name);
		this.setDepartmentCode(departmentCode);
		this.setPassword(password);
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDepartmentCode() {
		return departmentCode;
	}
	public void setDepartmentCode(String departmentCode) {
		this.departmentCode = departmentCode;
	}
	public String getCreatedUser() {
		return createdUser;
	}
	public void setCreatedUser(String createdUser) {
		this.createdUser = createdUser;
	}
	public Date getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
	public String getModifiedUser() {
		return modifiedUser;
	}
	public void setModifiedUser(String modifiedUser) {
		this.modifiedUser = modifiedUser;
	}
	public Date getModifiedTime() {
		return modifiedTime;
	}
	public void setModifiedTime(Date modifiedTime) {
		this.modifiedTime = modifiedTime;
	}
	
	public String getNewPassword() {
		return newPassword;
	}
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	public String getOldPassword() {
		return oldPassword;
	}
	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", password=" + password + ", departmentCode=" + departmentCode
				+ ", createdUser=" + createdUser + ", createdTime=" + createdTime + ", modifiedUser=" + modifiedUser
				+ ", modifiedTime=" + modifiedTime + "]";
	}
	

}
	