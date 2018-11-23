package com.primeton.lyx;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.primeton.lyx.controller.DepartmentController;
import com.primeton.lyx.model.Department;
import com.primeton.lyx.model.ResponseResult;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = LiyixinDemoApplication.class) 
public class DepartmentControllerTestCase {
	@Autowired
	private DepartmentController departmentController;
	@Test
	public void testDepartment() {
		this.testRemoveDepartment();
		this.testCreateDepartment();
		this.testModifyDepartment();
	}
	public void testCreateDepartment() {
		Department department=new Department("4","法律部","2");
		ResponseResult<Department>rr=departmentController.createDepartment(department);
		Assert.assertEquals((Integer)rr.getState(),(Integer)1);
	}
	public void testModifyDepartment() {
		Department department=new Department();
		department.setDname("领导部");
		department.setDepartmentCode("4");
		ResponseResult<Department>rr=departmentController.modifyDepartment(department);
		Assert.assertEquals((Integer)rr.getState(),(Integer)1);
	}
	public void testRemoveDepartment() {
		ResponseResult<Void>rr=departmentController.removeDepartment("4");
		Assert.assertEquals((Integer)rr.getState(),(Integer)1);
	}
}
