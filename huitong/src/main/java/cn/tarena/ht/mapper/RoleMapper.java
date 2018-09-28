package cn.tarena.ht.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.tarena.ht.pojo.Role;


public interface RoleMapper {
	
	/**
	 * 查询全部的角色信息
	 * @return
	 */
	public List<Role> findAll();
	
	/**
	 * 保存新添加的角色
	 * @param role
	 * @return
	 */
	public void saveRole(Role role);
	
	/**
	 * 删除角色
	 * @param roleIds
	 */
	public void deleteRoleById(String[] roleIds);
	
	/**
	 * 删角色-用户对应关系
	 * @param roleIds
	 */
	public void deleteRoleUserById(String[] roleIds);
	
	/**
	 * 修改角色
	 * @param role
	 */
	public void updateRole(Role role);
	
	/**
	 * 查找角色详细信息
	 * @param roleId
	 * @return
	 */
	public Role findRoleById(String roleId);
	
	/**
	 * 根据名称查角色
	 * @param name
	 * @return
	 */
	public Role findRoleByName(String name);
	
	/**
	 * 插入角色的模块信息
	 * @param roleId
	 * @param modules
	 */
	public void saveRoleModule(
			@Param(value="roleId") String roleId, 
			@Param(value="moduleIds") String[] modules);

}
