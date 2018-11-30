package com.primeton.lyx.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.primeton.lyx.dao.IUserMapper;
import com.primeton.lyx.enums.CustomEnum;
import com.primeton.lyx.exception.DemoException;
import com.primeton.lyx.model.User;
import com.primeton.lyx.util.CheckUtil;
/**
 * 用户管理服务层实现
 * @author 李一新
 *
 */
@Service("userService")
@Transactional(rollbackFor=Exception.class)
public class UserServiceImpl implements IUserService {
	@Autowired
	private IUserMapper userMapper;
	public User createUser(User user) {
		boolean reason=CheckUtil.checkUsername(user.getName());
		if(!reason) {
			//用户格式不正确
			throw new DemoException(CustomEnum.ERROR_FORMATNAME);
		}
	    reason=CheckUtil.checkPassword(user.getPassword());
	    if(!reason) {
	    	//密码格式不正确
	    	throw new DemoException(CustomEnum.ERROR_FORMATPASSWORD);
	    }
		User data=getUserByName(user.getName());
		if(data==null) {
			Date now=new Date();
			user.setCreatedUser(user.getName());
			user.setCreatedTime(now);
			user.setModifiedUser(user.getName());
			user.setModifiedTime(now);
			userMapper.insertUser(user);
			return user;
		}else {
			//用户名已存在
			throw new DemoException(CustomEnum.ERROR_REPEATNAME);
		}
	}

	public User modifyPassword(String newPassword, String oldPassword, Integer id) {
		User data=getUserById(id);
		if(data!=null) {
			if(data.getPassword().equals(oldPassword)) {
				Boolean reason=CheckUtil.checkPassword(newPassword);
				if(!reason) {
					//密码格式有误
					throw new DemoException(CustomEnum.ERROR_FORMATPASSWORD);
				}
				Date now=new Date();
				 userMapper.updatePassword(id, newPassword, data.getName(),now);
				 data.setModifiedTime(now);
				 data.setPassword(newPassword);
				 data.setModifiedUser(data.getName());
				 return data;
				 
			}else {
				//原密码不匹配
				throw new DemoException(CustomEnum.ERROR_MATCHPASSWORD);
			}
		}else {
			//用户不存在
				throw new DemoException(CustomEnum.ERROR_NOTHAVA);
		}
		
	}

	public Integer removeUser(Integer id) {
		User data=getUserById(id);
		if(data!=null) {
			Integer rows=userMapper.deleteById(id);
			return rows;
		}else {
			//用户不存在
			throw new DemoException(CustomEnum.ERROR_NOTHAVA);
		}
	}
	public User login(String name,String password) {
		User data=getUserByName(name);
		if(data!=null) {
			if(data.getPassword().equals(password)) {
				data.setPassword(password);
				return data;
			}else {
				//密码错误
				throw new DemoException(CustomEnum.ERROR_PASSWORDBUG);
			}
		}else {
			//用户名不存在
			throw new DemoException(CustomEnum.ERROR_NOTNAME);
		}
	}

	public User getUserByName(String name) {
		return userMapper.getUserByName(name);
	}

	public User getUserById(Integer id) {
		return userMapper.getUserById(id);
	}

	@Override
	public List<User> queryByLikename(String name, Integer page, Integer size) {
		PageHelper.startPage(page, size);
		return userMapper.queryUsersByKeyWord("%"+name+"%");
	}

}
