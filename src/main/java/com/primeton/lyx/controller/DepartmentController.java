package com.primeton.lyx.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.primeton.lyx.model.Department;
import com.primeton.lyx.model.ResponseResult;
import com.primeton.lyx.service.IDepartmentService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
/**
 * 部门管理控制器实现部门增删改查
 * @author 李一新
 *
 */
@RequestMapping("/api/departments")
@RestController
@Api(value = "部门管理api", tags = "部门管理接口")
public class DepartmentController {
	@Autowired
	private IDepartmentService departmentService;
	/**
	 * 
	 * @param departmentCode 部门号
	 * @param dname 部门名称
	 * @param updepartmentCode 上级部门号
	 * @return 结果对象
	 */
	@PostMapping
	@ApiOperation("创建部门")
	public ResponseResult<Department> createDepartment(
			@ApiParam("保存的部门信息")@RequestBody Department department){
		ResponseResult<Department> rr;
		Department data=departmentService.createDepartment(department);
		rr=new ResponseResult<Department>(ResponseResult.STATE_OK,data);
		return rr;
	}
	/**
	 * 
	 * @param departmentCode 部门号
	 * @param dname 部门名称
	 * @return 结果对象
	 */
	@ApiOperation("更新部门名称")
	@PutMapping
	public ResponseResult<Department> modifyDepartment(@RequestBody Department department){
		ResponseResult<Department>rr;
		Department data=departmentService.modifyDepartment(department.getDname(), department.getDepartmentCode());
		rr=new ResponseResult<Department>(ResponseResult.STATE_OK,data);
		return rr;
	}
	/**
	 * 
	 * @param departmentCode 部门号
	 * @return 结果信息
	 */
	@ApiOperation("删除部门")
	@DeleteMapping(value="/{departmentCode}")
	public ResponseResult<Void> removeDepartment(@ApiParam("部门号")@PathVariable("departmentCode")String departmentCode ){
		ResponseResult<Void>rr;
		departmentService.removeDepartment(departmentCode);
		rr=new ResponseResult<Void>(ResponseResult.STATE_OK);
		return rr;
	}
	/**
	 * 
	 * @param departmentCode 部门号
	 * @return 部门对象
	 */
	@ApiOperation("通过部门号查找用户信息")
	@GetMapping("/{departmentCode}")
	public ResponseResult<Department>getDepartmentByDepartmentCode(@ApiParam("部门号")@PathVariable("departmentCode")String departmentCode){
		ResponseResult<Department>rr;
		Department data=departmentService.getDepartmentByDepartmentCode(departmentCode);
		rr=new ResponseResult<Department>(ResponseResult.STATE_OK,data);
		return rr;
	}
	@ApiOperation("通过上级部门查询子集部门")
	@GetMapping("/query/{updepartmentCode}")
	public ResponseResult<List<Department>>querdownByupDepartmentCode(@ApiParam("部门号")@PathVariable("updepartmentCode")String updepartmentCode){
		ResponseResult<List<Department>>rr;
		List<Department> data=departmentService.querdownByupDepartmentCode(updepartmentCode);
		rr=new ResponseResult<List<Department>>(ResponseResult.STATE_OK,data);
		return rr;
	}
	
}
