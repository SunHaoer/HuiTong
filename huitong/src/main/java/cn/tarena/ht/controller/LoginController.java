package cn.tarena.ht.controller;

import javax.servlet.http.HttpSession;

import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.tarena.ht.pojo.User;
import cn.tarena.ht.service.UserService;

@Controller
public class LoginController {
	
	@Autowired
	private UserService userService;
	
	// 点击登出按钮，页面跳转
	@RequestMapping(value="/logout")
	public String toLoginOut(HttpSession session) {
		User user = (User)session.getAttribute("sessionUser");
		session.setAttribute("sessionUser", null);
		return "sysadmin/login/login";
	}
	
	// 点击登录按钮，页面跳转
	@RequestMapping(value="/login")
	public String toLogin(String userName, String password, Model model, HttpSession session) {
		if(StringUtils.isEmpty(userName) || StringUtils.isEmpty(password)) {		// 验证用户名密码是否为空
			// 验证结果，信息填充
			model.addAttribute("errorInfo", "用户名或密码不能为空");
			return "/sysadmin/login/login";
		}
		// 验证用户名密码是否匹配
		// 查询数据库是否有此人，查询此人的部门信息
		User user = userService.checkLoginByUser(userName, password);
for(int i = 0; i < 10; i++) System.out.println("");
System.out.println(user);
		if(StringUtils.isEmpty(user) || user == null) {
			model.addAttribute("errorInfo", "用户名或密码不正确");
			return "/sysadmin/login/login";
		}
		// 登录成功，把数据放入session对象
		session.setAttribute("sessionUser", user);
		return "redirect:/home.action";
	}
}
