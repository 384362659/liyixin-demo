package com.primeton.lyx;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.primeton.lyx.controller.UserController;
import com.primeton.lyx.model.ResponseResult;
import com.primeton.lyx.model.User;
import com.primeton.lyx.service.IUserService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = LiyixinDemoApplication.class) 
public class UserControllerTestCase {
	@Autowired
	private UserController userController;
	@Autowired
	private IUserService userService;
	/**
	 * 测试方法重复执行
	 */
	@Test
	public void testUser() {
		this.testRemoveUser();
		this.testCreateUser();
		this.testLogin();
		this.testModifyUser();
	}
	/**
	 * 添加用户方法
	 */
	public void testCreateUser() {
		User user=new User("petter","7771111","2");
		ResponseResult<User>rr=userController.createUser(user);
		Assert.assertEquals((Integer)rr.getState(),(Integer)1);
	}
	public void testRemoveUser() {
		User user=userService.getUserByName("petter");
		ResponseResult<Void>rr=userController.removeUser(user.getId());
		Assert.assertEquals((Integer)rr.getState(), (Integer)1);
	}
	public void testModifyUser() {
		User user=userService.getUserByName("petter");
		User emp=new User();
		emp.setId(user.getId());
		emp.setOldPassword("7771111");
		emp.setNewPassword("878787");
		ResponseResult<User>rr=userController.modifyPassword(emp);
		Assert.assertEquals((Integer)rr.getState(),(Integer) 1);
	}
	public void testLogin() {
		User user=new User();
		user.setName("petter");
		user.setPassword("7771111");
		ResponseResult<User>rr=userController.login(user);
		Assert.assertEquals((Integer)rr.getState(),(Integer)1);
	}
}
