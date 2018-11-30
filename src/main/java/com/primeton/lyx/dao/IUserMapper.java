package com.primeton.lyx.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.primeton.lyx.model.User;
/**
 * 用户管理持久层
 * @author 李一新
 *
 */
@Mapper
public interface IUserMapper {
	/**
	 * 
	 * @param user 用户
	 * @return 受影响的行数，如果增加成功，则返回1，否则返回0
	 */
	@Options(useGeneratedKeys=true,keyProperty="id",keyColumn="id")
	@Insert("INSERT INTO LYX_USER"
			+   "(NAME,PASSWORD,DEPARTMENTCODE,"
			+ "CREATED_USER,CREATED_TIME,"
			+ "MODIFIED_USER,MODIFIED_TIME) "
			+ "VALUES"
			+ "(#{name},#{password},#{departmentCode},"
			+ "#{createdUser},#{createdTime},"
			+ "#{modifiedUser},#{modifiedTime})")
	 Integer insertUser(User user);
	/**
	 * 修改密码
	 * @param id 用户id
	 * @param password 新密码
	 * @param modifiedUser 修改用户
	 * @param modifiedTime 修改时间
	 * @return 受影响行数，正确操作情况下返回1，否则返回0
	 */
	@Update("UPDATE LYX_USER SET PASSWORD=#{password},MODIFIED_USER=#{modifiedUser},MODIFIED_TIME=#{modifiedTime} WHERE ID=#{id}")
	Integer updatePassword(@Param("id")Integer id,@Param("password")String password,@Param("modifiedUser")String modifiedUser,@Param("modifiedTime")Date modifiedTime);
	/**
	 * 删除用户
	 * @param id 用户id
	 * @return 受影响行数，正确操作情况下返回1，否则返回0
	 */
	@Delete("DELETE FROM LYX_USER WHERE ID=#{id}")
	Integer deleteById(Integer id);
	/**
	 * 根据用户名查询用户数据
	 * @param name 用户名
	 * @return 与参数用户名匹配的用户数据，如果没有匹配的数据，则返回null
	 */
	@Select("SELECT ID,NAME,PASSWORD,DEPARTMENTCODE,CREATED_USER CREATEDUSER,CREATED_TIME CREATEDTIME,"
			+ "MODIFIED_USER MODIFIEDUSER,MODIFIED_TIME MODIFIEDTIME FROM LYX_USER WHERE NAME=#{name}")
	 User getUserByName(String name);
	/**
	 * 根据id查询用户数据
	 * @param id 用户的id
	 * @return 与参数用户id匹配的用户数据，如果没有匹配的数据，则返回null
	 */
	@Select("SELECT ID,NAME,PASSWORD,DEPARTMENTCODE,CREATED_USER CREATEDUSER,CREATED_TIME CREATEDTIME,"
			+ "MODIFIED_USER MODIFIEDUSER,MODIFIED_TIME MODIFIEDTIME FROM LYX_USER WHERE ID=#{id}")
	User getUserById(Integer id) ;
	/**
	 * 根据用户名模糊查询用户数据
	 * @param name
	 * @return
	 */
	@Select("SELECT ID,NAME,PASSWORD,DEPARTMENTCODE,CREATED_USER CREATEDUSER,CREATED_TIME CREATEDTIME,"
			+ "MODIFIED_USER MODIFIEDUSER,MODIFIED_TIME MODIFIEDTIME FROM LYX_USER WHERE NAME LIKE #{name}")
	List<User>queryUsersByKeyWord(String name);
}	

