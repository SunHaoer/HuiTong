package cn.tarena.ht.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import cn.tarena.ht.pojo.Dept;
import cn.tarena.ht.pojo.Role;
import cn.tarena.ht.pojo.User;
import cn.tarena.ht.service.DeptService;
import cn.tarena.ht.service.RoleService;
import cn.tarena.ht.service.UserService;
import cn.tarena.ht.tool.PageBean;

@Controller
@RequestMapping(value="/sysadmin/user")			// 请求的公共部分
public class UserController extends BaseController {
	
	@Autowired
	private UserService userService;
	@Autowired
	private DeptService deptService;
	@Autowired
	private RoleService roleService;
	
	/**
	 * 用户列表页面的跳转
	 * @param currentPage
	 * @param pageSize
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/list")
	public String toUserList(
			@RequestParam(defaultValue="1") int currentPage, 
			@RequestParam(defaultValue="10") int pageSize, Model model) {	// 查询分页的数据：默认每一页为10条数据，从0开始
		PageBean<User> pageBean = userService.findUserByPages(currentPage, pageSize);
		List<User> userList = pageBean.getPageList();
		model.addAttribute("pageBean", pageBean);		// 数据填充
		model.addAttribute("userList", userList);
		
		return "/sysadmin/user/jUserList";
	}
	
	
	/**
	 * 打开新增用户登记表
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/tosave")
	public String toSaveUser(Model model) {
		List<User> userInfoList = userService.findManagerUser();	// 准备上级领导的信息
		List<Dept> deptList = deptService.findAll();	// 准备所属部门的信息
		model.addAttribute("userInfoList", userInfoList);
		model.addAttribute("deptList", deptList);
		return "/sysadmin/user/jUserSave";
	}
	
	/**
	 * 保存新添加的用户
	 * @param user
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/save")
	public String saveUser(User user, Model model) {
		// 校验用户的用户名是否存在
		
		// 调用service层的保存方法
		userService.saveUser(user);
		// 重定向
		return "redirect:/sysadmin/user/list";
	}
	
	/**
	 * 跳转到角色页面
	 * @return
	 * @throws JsonProcessingException 
	 */
	@RequestMapping(value="torole")
	public String toUserRole(Model model, String userId) throws JsonProcessingException {
		List<Role> roleList = roleService.findAll();		// 查询真实全部的角色信息
		List<String> userRoles = userService.findUserRoleByUserId(userId);		// 根据userId查询所有已经勾选的信息
		for(Role role : roleList) {
			for(String roleId : userRoles) {
				if(roleId.equals(role.getRoleId())) {
					role.setChecked(true);
				}
			}
		}
		ObjectMapper objectMapper = new ObjectMapper();		// 使用ObjectMapper类进行转换
		String zTreeJson = objectMapper.writeValueAsString(roleList);
		model.addAttribute("zTreeJson", zTreeJson);
		model.addAttribute("userId", userId);
		return "/sysadmin/user/jUserRole";
	}
	
	/**
	 * 保存角色，数据保存到role_user_p的中间表中
	 * @return
	 */
	@RequestMapping(value="saveUserRole")
	public String saveRole(String userId, String roleIds) {
		userService.saveUserRole(userId, roleIds);
		return "redirect:/sysadmin/user/list";
	}
	
}
