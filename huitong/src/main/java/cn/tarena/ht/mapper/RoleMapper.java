package cn.tarena.ht.mapper;

import java.util.List;

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

}
