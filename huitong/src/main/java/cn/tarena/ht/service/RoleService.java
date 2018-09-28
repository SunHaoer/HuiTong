package cn.tarena.ht.service;

import java.util.List;

import cn.tarena.ht.pojo.Role;

public interface RoleService {
	
	/**
	 * 查询全部的角色信息
	 * @return
	 */
	public List<Role> findAll();
	
	/**
	 * 保存新添加的角色
	 * @param role
	 */
	public void saveRole(Role role);
	
	/**
	 * 删除角色
	 * @param roleIds
	 */
	public void deleteRoleById(String[] roleIds);
	
	/**
	 * 修改角色信息
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
	 * 根据角色名称查角色
	 * @param name
	 * @return true(存在) || false(不存在)
	 */
	public boolean findUserByName(String name);
	
}
