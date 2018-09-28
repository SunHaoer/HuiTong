package cn.tarena.ht.controller;

import javax.servlet.http.HttpSession;

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
	
	/**
	 * 控制用户登录与登出
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/logout")
	public String toLoginOut(HttpSession session) {		
		if(session.getAttribute("sessionUser") != null) {		// 已登录，登出
			session.setAttribute("sessionUser", null);
			return "redirect:/home.action";
		} else {				// 未登录
			return "sysadmin/login/login";
		}
	}
	
	/**
	 * 验证用户登录
	 * @param userName
	 * @param password
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/login")
	public String toLogin(String userName, String password, Model model, HttpSession session) {		// 登录
		if(StringUtils.isEmpty(userName) || StringUtils.isEmpty(password)) {		// 验证用户名密码是否为空
			model.addAttribute("errorInfo", "用户名或密码不能为空");
			return "/sysadmin/login/login";
		}
		User user = userService.checkLoginByUser(userName, password);
		if(StringUtils.isEmpty(user) || user == null) {		// 验证用户名密码是否匹配
			model.addAttribute("errorInfo", "用户名或密码不正确");
			return "/sysadmin/login/login";
		}
		session.setAttribute("sessionUser", user);		// 登录成功，把数据放入session对象
		return "redirect:/home.action";
	}
}
