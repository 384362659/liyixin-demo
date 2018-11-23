package com.primeton.lyx.controller;

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

import com.primeton.lyx.model.ResponseResult;
import com.primeton.lyx.model.User;
import com.primeton.lyx.service.IUserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
/**
 * 用户管理控制器实现用户增删改查
 * @author 李一新
 *
 */
@RequestMapping("/api/users")
@Api(value = "员工管理api", tags = "员工管理接口")
@RestController
public class UserController {
	@Autowired
	private IUserService userService;
	/**
	 * 
	 * @param user 新增的用户对象
	 * @return 用户信息
	 */
	@PostMapping
	@ApiOperation("创建新用户")
	public ResponseResult<User>createUser(
			@ApiParam("保存的用户信息")@RequestBody User user){
		ResponseResult<User> rr;
		User emp=new User(user.getName(),user.getPassword(),user.getDepartmentCode());
		User data=userService.createUser(emp);
		rr=new ResponseResult<User>(ResponseResult.STATE_OK,data);
		return rr;	
	}
	/**
	 * 删除
	 * @param id 用户id
	 * @return 用户状态
	 */
	@ApiOperation("删除用户")
	@DeleteMapping(value="/{id}")
	public ResponseResult<Void> removeUser(@ApiParam("用户id")@PathVariable("id")Integer id){
		ResponseResult<Void> rr;
		userService.removeUser(id);
		rr=new ResponseResult<Void>(ResponseResult.STATE_OK);
		return rr;
	}
	/**
	 * 
	 * @param id 用户id
	 * @param oldPassword 用户原密码
	 * @param newPassword 用户新密码
	 * @return 用户状态
	 */
	@ApiOperation("修改用户密码")
	@PutMapping
	public ResponseResult<User>modifyPassword(@ApiParam("修改的用户信息")@RequestBody User user){
		ResponseResult<User> rr;
		User data=userService.modifyPassword(user.getNewPassword(), user.getOldPassword(), user.getId());
		rr=new ResponseResult<User>(ResponseResult.STATE_OK,data);
		return rr;
	}
	/**
	 * 登陆
	 * @param name 用户名称
	 * @param password 用户密码
	 * @return 用户状态
	 */
	@ApiOperation("用户登录")
	@PostMapping("/actions/login")
	public ResponseResult<User>login(@ApiParam("用户登录的信息")@RequestBody User user){
		ResponseResult<User>rr;
		User data=userService.login(user.getName(),user.getPassword());
		rr=new ResponseResult<User>(ResponseResult.STATE_OK,data);
		return rr;
	}
	/**
	 * 
	 * @param id 用户id
	 * @return 用户 数据
	 */
	@ApiOperation("通过用户id查找用户信息")
	@GetMapping("/{id}")
	public ResponseResult<User>getUserById(@ApiParam("用户id")@PathVariable("id") Integer id){
		ResponseResult<User>rr;
		User data=userService.getUserById(id);
		rr=new ResponseResult<User>(ResponseResult.STATE_OK,data);
		return rr;
	}
}
