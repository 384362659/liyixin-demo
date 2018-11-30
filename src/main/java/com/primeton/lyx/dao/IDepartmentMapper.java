package com.primeton.lyx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.primeton.lyx.model.Department;
import com.primeton.lyx.model.User;
/**
 * 部门组织机构管理持久层
 * @author 李一新
 *
 */
public interface IDepartmentMapper {
	/**
	 * 添加部门
	 * @param department 部门对象
	 * @return 受影响行数
	 */
	@Options(useGeneratedKeys=true,keyProperty="departmentId",keyColumn="departmentId")
	@Insert("INSERT INTO "
			+ "LYX_DEPARTMENT"
			+ "(DEPARTMENTCODE,DNAME,UPDEPARTMENTCODE) "
			+ "VALUES"
			+ "(#{departmentCode}, #{dname}, #{updepartmentCode})")
	public Integer insertDepartment(Department department);
	/**
	 * 删除部门
	 * @param departmentCode 部门号
	 * @return 受影响行数
	 */
	@Delete("DELETE FROM LYX_DEPARTMENT WHERE DEPARTMENTCODE=#{departmentCode}  ")
	public Integer deleteDepartment(String departmentCode);
	/**
	 * 根据部门号修改部门名称
	 * @param dname 部门名称
	 * @param departmentCode 部门号
	 * @return 受影响行数
	 */
	@Update("UPDATE LYX_DEPARTMENT SET DNAME=#{dname} WHERE DEPARTMENTCODE=#{departmentCode}")
	public Integer updateDepartment(@Param("dname")String dname,@Param("departmentCode")String departmentCode);
	/**
	 * 
	 * 根据部门号查询部门
	 * @param departmentCode 部门号
	 * @return 部门对象
	 */
	@Select("SELECT DEPARTMENTID,DEPARTMENTCODE,DNAME,UPDEPARTMENTCODE FROM LYX_DEPARTMENT WHERE DEPARTMENTCODE=#{departmentCode}")
	public Department getDepartmentByDepartmentCode(String departmentCode);
	/**
	 * 根据部门名称查询部门
	 * @param dname 部门名称
	 * @return 部门对象
	 */
	@Select("SELECT DEPARTMENTID,DEPARTMENTCODE,DNAME,UPDEPARTMENTCODE FROM LYX_DEPARTMENT WHERE DNAME=#{dname}")
	public Department getDepartmentByDname(String dname);
	/**
	 * 根据上级部门号查询子集部门
	 * @param updepartmentCode 上级部门号
	 * @return 部门对象集合
	 */
	@Select("SELECT DEPARTMENTID,DNAME,DEPARTMENTCODE,UPDEPARTMENTCODE FROM LYX_DEPARTMENT WHERE UPDEPARTMENTCODE=#{updepartmentCode}")
	public List<Department> querydownByupDepartmentCode(String updepartmentCode);
	/**
	 * 根据部门号查询部门员工
	 * @param departmentCode 部门号
	 * @return 员工对象集合
	 */
	@Select("SELECT"
			+ " U.ID, U.NAME,U.DEPARTMENTCODE,U.CREATED_USER CREATEDUSER,U.CREATED_TIME CREATEDTIME, "
			+ "U.MODIFIED_TIME MODIFIEDTIME,U.MODIFIED_USER MODIFIEDUSER "
			+ "FROM "
			+ "LYX_USER U "
			+ "JOIN "
			+ " LYX_DEPARTMENT D "
			+ "ON "
			+ "(U.DEPARTMENTCODE = D.DEPARTMENTCODE) "
			+ "WHERE "
			+ "U.DEPARTMENTCODE=#{departmentCode}")
	public List<User> queryUserByDepartmentCode(String departmentCode);
	/**
	 * 
	 * @param dname
	 * @return
	 */
	@Select("SELECT DEPARTMENTID,DEPARTMENTCODE,DNAME,UPDEPARTMENTCODE FROM LYX_DEPARTMENT WHERE DNAME LIKE #{dname}")
	public List<Department>queryByLikeName(String dname);
	@Select("SELECT"
			+ " U.ID,D.DNAME, U.NAME,U.DEPARTMENTCODE,U.CREATED_USER CREATEDUSER,U.CREATED_TIME CREATEDTIME, "
			+ "U.MODIFIED_TIME MODIFIEDTIME,U.MODIFIED_USER MODIFIEDUSER "
			+ "FROM "
			+ "LYX_USER U "
			+ "JOIN "
			+ " LYX_DEPARTMENT D "
			+ "ON "
			+ "(U.DEPARTMENTCODE = D.DEPARTMENTCODE) "
			+ "WHERE "
			+ "D.Dname=#{dname}")
	public List<User> queryUserByDname(String dname);
}
