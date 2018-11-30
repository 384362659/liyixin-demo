package com.primeton.lyx.service;

import java.util.List;

import com.primeton.lyx.model.User;
/**
 * 用户管理服务层接口
 * @author 李一新
 *
 */
public interface IUserService {
	/**
	 * 增加员工
	 * @param user 员工对象
	 * @return 员工对象
	 */
	public User createUser(User user);
	/**
	 * 根据id修改密码
	 * @param newPassword 新密码
	 * @param oldPassword 原密码
	 * @param id  员工id
	 * @return 员工对象
	 */
	public User modifyPassword(String newPassword,String oldPassword,Integer id);
	/**
	 * 根据id删除员工
	 * @param id 员工id
	 * @return 受影响行数
	 */
	public Integer removeUser(Integer id);
	/**
	 *  根据用户名查询员工数据
	 * @param name 员工姓名
	 * @return 员工数据
	 */
	public User getUserByName(String name);
	/**
	 * 根据员工id查询员工数据
	 * @param id 员工id
	 * @return 员工数据
	 */
	public User getUserById(Integer id);
	/**
	 * 登陆
	 * @param name 员工名称
	 * @param password 员工密码
	 * @return 员工数据
	 */
	public User login(String name,String password);
	/**
	 * 根据员工名称模糊查询员工信息
	 * @param name 员工名称
	 * @param page
	 * @param size
	 * @return
	 */
	public List<User> queryByLikename(String name,Integer page,Integer size);
}