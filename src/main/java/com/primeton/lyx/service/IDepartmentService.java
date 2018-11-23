package com.primeton.lyx.service;

import java.util.List;
import com.primeton.lyx.model.Department;
import com.primeton.lyx.model.User;
/**
 * 部门管理服务层接口
 * @author 李一新
 *
 */
public interface IDepartmentService {
	/**
	 * 添加部门
	 * @param department 部门对象
	 * @return 部队对象
	 */
	public Department createDepartment(Department department);
	
	/**
	 * 删除部门，如果有下级部门提示不可删除，如果部门有人员提示不可删除
	 * @param departmentCode 部门号
	 * @return 
	 */
	public Integer removeDepartment(String departmentCode);
	/**
	 * 
	 * @param dname 部门名称
	 * @param departmentCode 部门号
	 * @return 受影响行数
	 */
	public Department modifyDepartment(String dname,String departmentCode);
	/**
	 * 根据部门查询下属部门
	 * @param updepartmentCode 上级部门号
	 * @return 下属部门对象集合
	 */
	public List<Department> querdownByupDepartmentCode(String updepartmentCode);
	/**
	 * 从部门号查询部门信息
	 * @param departmentCode 部门号
	 * @return 部门对象
	 */
	public Department getDepartmentByDepartmentCode(String departmentCode);
	/**
	 * 从部门名称查询部门信息
	 * @param dname 部门名称
	 * @return 部门对象
	 */
	public Department getDepartmentByDname(String dname);
	/**
	 * 从部门号查询部门全部员工信息
	 * @param departmentCode 部门号
	 * @return 员工对象集合
	 */
	public List<User> queryUserByDepartmentCode(String departmentCode);
	
	
}
