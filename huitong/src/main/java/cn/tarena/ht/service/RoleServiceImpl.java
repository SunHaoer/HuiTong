package cn.tarena.ht.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tarena.ht.mapper.RoleMapper;
import cn.tarena.ht.mapper.UserMapper;
import cn.tarena.ht.pojo.Role;

@Service
public class RoleServiceImpl implements RoleService {
	
	@Autowired
	private RoleMapper roleMapper;
	
	@Override
	public List<Role> findAll() {
		return roleMapper.findAll();
	}

	@Override
	public void saveRole(Role role) {
		String roleId = UUID.randomUUID().toString();		// 自动生成主键
		role.setRoleId(roleId);
		roleMapper.saveRole(role);
	}

	@Override
	public void deleteRoleById(String[] roleIds) {
		roleMapper.deleteRoleById(roleIds);
		roleMapper.deleteRoleUserById(roleIds);
	}

	@Override
	public void updateRole(Role role) {
		roleMapper.updateRole(role);
	}

	@Override
	public Role findRoleById(String roleId) {
		return roleMapper.findRoleById(roleId);
	}

	@Override
	public boolean findUserByName(String name) {
		Role role = roleMapper.findRoleByName(name);
		if(role == null) {		// 该名称未被占用，可以使用
			return true;
		} else {				// 该名称已被占用，不可使用
			return false;
		}
	}

}
