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
	
}
