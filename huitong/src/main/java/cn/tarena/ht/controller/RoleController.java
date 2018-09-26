package cn.tarena.ht.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.tarena.ht.pojo.Role;
import cn.tarena.ht.service.RoleService;

@Controller
@RequestMapping(value="/sysadmin/role/")
public class RoleController {
	
	@Autowired
	private RoleService roleService;
	
	/**
	 * 查询所有的角色信息
	 * @param model
	 * @return
	 */
	@RequestMapping(value="list")
	public String toRoleList(Model model) {
		List<Role> roleList = roleService.findAll();
		model.addAttribute("roleList", roleList);
		return "/sysadmin/role/jRoleList";
	}
	
	/**
	 * 打开新添加角色登记表
	 * @return
	 */
	@RequestMapping(value="tosave")
	public String toSaveRole() {
		return "/sysadmin/role/jRoleSave";
	}
	
	/**
	 * 保存新添加的角色
	 * @return
	 */
	@RequestMapping(value="save")
	public String saveRole(Role role) {
		// 校验非空
		
		// 保存
		roleService.saveRole(role);
		return "redirect:/sysadmin/role/list";
	}
	
	/**
	 * 删除角色
	 * @param roleIds
	 * @return
	 */
	@RequestMapping(value="delete")
	public String deleteRole(
			@RequestParam(value="roleId",defaultValue="0") String[] roleIds) {
		//System.out.println(roleIds);
		roleService.deleteRoleById(roleIds);
		return "redirect:/sysadmin/role/list";
	}
	
	/**
	 * 打开角色更新登记表
	 * @param role
	 * @return
	 */
	@RequestMapping(value="toupdate")
	public String toUpdateRole(Role role) {
		return "/sysadmin/role/jRoleUpdate";
	}
	
	/**
	 * 保存更新的角色
	 * @param role
	 * @return
	 */
	@RequestMapping(value="update")
	public String updateRole(Role role) {
		roleService.updateRole(role);
		return "redirect:/sysadmin/role/list";
	}
	
	/**
	 * 查看角色详细信息
	 * @return
	 */
	@RequestMapping(value="toview")
	public String toViewRole(Model model, String roleId) {
		Role role = roleService.findRoleById(roleId);
		model.addAttribute("role", role);
		return "/sysadmin/role/jRoleView";
	}
	
}
