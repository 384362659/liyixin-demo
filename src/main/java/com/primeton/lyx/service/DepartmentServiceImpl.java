package com.primeton.lyx.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.primeton.lyx.dao.IDepartmentMapper;
import com.primeton.lyx.enums.CustomEnum;
import com.primeton.lyx.exception.DemoException;
import com.primeton.lyx.model.Department;
import com.primeton.lyx.model.User;
/**
 * 部门管理服务层实现
 * @author 李一新
 *
 */
@Service("departmentService")
@Transactional(rollbackFor=Exception.class)
public class DepartmentServiceImpl implements IDepartmentService {
	@Autowired
	IDepartmentMapper departmentMapper;
	@Override
	public Department createDepartment(Department department) {
		if(department.getDname()!=null&&department.getDepartmentCode()!=null) {
			Department data=this.getDepartmentByDname(department.getDname());
				if(data==null) {
					departmentMapper.insertDepartment(department);
					return department;
				}else {
					//部门已经被注册
					throw new DemoException(CustomEnum.ERROR_HAVEDEPARTMENT);
				}
		}else {
			//部门号和部门名称不能为空
			throw new DemoException(CustomEnum.ERROR_NULLDEPARTMENT);
		}
	}

	public Integer removeDepartment(String departmentCode) {
		if(departmentCode!=null) {
			List<User>listUsers=this.queryUserByDepartmentCode(departmentCode);
			List<Department>listdepartments=this.querdownByupDepartmentCode(departmentCode);
			if(listUsers.size()==0&&listdepartments.size()==0) {
				Integer rows=departmentMapper.deleteDepartment(departmentCode);
				return rows;
			}else {
				//部门底下有员工或者部门
				throw new DemoException(CustomEnum.ERROR_DELETE);
			}
		}else {
			//部门号不能为空
			throw new DemoException(CustomEnum.ERROR_NULLDEPARTMENTCODE);
		}
		
	}
	public Department modifyDepartment(String dname, String departmentCode) {
		if(departmentCode!=null&&dname!=null) {
			Department data=this.getDepartmentByDepartmentCode(departmentCode);
			if(data!=null) {
				Department dep=this.getDepartmentByDname(dname);
				 if(dep==null) {
					 departmentMapper.updateDepartment(dname, departmentCode);
					 data.setDname(dname);
					 return data;
				 }else {
					 //更新失败
					 throw new DemoException(CustomEnum.ERROR_CHANGE);
				 }
			}else {
				//没有这个部门
				throw new DemoException(CustomEnum.ERROT_NULLORG);
			}
		}else {
			//部门号和部门名称不能为空
			throw new DemoException(CustomEnum.ERROR_NULLDEPARTMENT);
		}
		
	}
	/**
	 *  根据上级部门号查询子部门
	 */
	public List<Department> querdownByupDepartmentCode(String updepartmentCode) {
		return departmentMapper.querydownByupDepartmentCode(updepartmentCode);
	}
	/**
	 * 根据部门号查询部门
	 */
	public Department getDepartmentByDepartmentCode(String departmentCode) {
		return departmentMapper.getDepartmentByDepartmentCode(departmentCode);
	}

	/**
	 * 根据部门名称查询部门
	 */
	public Department getDepartmentByDname(String dname) {
		return departmentMapper.getDepartmentByDname(dname);
	}
    /**
     * 根据部门号查询员工
     */
	public List<User> queryUserByDepartmentCode(String departmentCode) {
		return departmentMapper.queryUserByDepartmentCode(departmentCode);
	}

	

}
