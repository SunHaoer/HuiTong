package pro.sunhao.ht.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import pro.sunhao.ht.pojo.Module;
import pro.sunhao.ht.pojo.Role;
import pro.sunhao.ht.service.ModuleService;
import pro.sunhao.ht.service.RoleService;

@Controller
@RequestMapping(value="/sysadmin/role/")
public class RoleController {
	
	@Autowired
	private RoleService roleService;
	@Autowired
	private ModuleService moduleService;
	
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
	public String saveRole(Model model, Role role) {
		if(StringUtils.isEmpty(role.getName())) {		// 校验非空
			model.addAttribute("errorInfo", "角色名称不能为空");
			return "/sysadmin/role/jRoleSave";
		}
		boolean access = roleService.findUserByName(role.getName());
		if(!access) {		// 该名称已经被占用
			model.addAttribute("errorInfo", "该名称已被占用");
			return "/sysadmin/role/jRoleSave";
		}
		roleService.saveRole(role);			// 保存
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
	public String toUpdateRole(Model model, String roleId) {
		Role role = roleService.findRoleById(roleId);
		model.addAttribute("role", role);
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
	
	/**
	 * 点击模块按钮，页面跳转：角色分配页面
	 * @return
	 * @throws JsonProcessingException 
	 */
	@RequestMapping(value="tomodule")
	public String toRoleModule(Model model, String roleId) throws JsonProcessingException {
		List<String> checkedModule = moduleService.findRoleModuleByRoleId(roleId);
		List<Module> moduleList = moduleService.findAll();
		for(Module module : moduleList) {
			if(checkedModule.contains(module.getModuleId())) {
				module.setChecked(true);
			}
		}
		ObjectMapper objectMapper = new ObjectMapper();
		String zTreeJson = objectMapper.writeValueAsString(moduleList);
		model.addAttribute("zTreeJson", zTreeJson);
		model.addAttribute("roleId", roleId);
		return "sysadmin/role/jRoleModule";
	}
	
	/**
	 * 保存角色的模块信息
	 * @param roleId
	 * @param moduleIds
	 * @return
	 */
	@RequestMapping(value="saveRoleModule")
	public String saveRoleModule(String roleId, String moduleIds) {
		roleService.saveRoleModule(roleId, moduleIds);
		return "redirect:/sysadmin/role/list";
	}
	
}
