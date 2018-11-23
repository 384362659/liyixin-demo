package com.primeton.lyx.model;

import java.io.Serializable;
/**
 * 部门组织机构实体类
 * @author 李一新
 *
 */


public class Department implements Serializable{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -4869185696782086035L;

	/**
     * 组织部门ID
     */
   
    private Integer departmentId;

    /**
     * 组织部门名称
     */
   
    private String dname;

    /**
     * 上级组织部门号
     */
    private String updepartmentCode;

	/**
	 * 组织部门号
	 */

	private  String  departmentCode;
	
	
	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Department(String departmentCode,String dname,String updepartmentCode) {
		this.setDepartmentCode(departmentCode);
		this.setDname(dname);
		this.setUpdepartmentCode(updepartmentCode);
	}
	public Department(Integer departmentId,String departmentCode,String dname,String updepartmentCode) {
		this.setDepartmentId(departmentId);
		this.setDepartmentCode(updepartmentCode);
		this.setDname(dname);
		this.setUpdepartmentCode(updepartmentCode);
	}

	public Integer getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public String getUpdepartmentCode() {
		return updepartmentCode;
	}

	public void setUpdepartmentCode(String updepartmentCode) {
		this.updepartmentCode = updepartmentCode;
	}

	public String getDepartmentCode() {
		return departmentCode;
	}

	public void setDepartmentCode(String departmentCode) {
		this.departmentCode = departmentCode;
	}

	@Override
	public String toString() {
		return "Department [departmentId=" + departmentId + ", dname=" + dname + ", updepartmentCode="
				+ updepartmentCode + ", departmentCode=" + departmentCode + "]";
	}


}