package cn.tarena.ht.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping("/home")
	public String home(){	//转向欢迎页面
		return "/home/fmain";
	}
	
	@RequestMapping("/title")
	public String title(){		//转向tilte标题栏页面
		return "/home/title";
	}
	
	//使用RestFul的风格 定义请求的方法
	//对应着前端页面： moduleName+'/Left.action'
	@RequestMapping(value="/{moduleName}/Left.action")
	public String moduelLeft(@PathVariable String moduleName) {
		return moduleName+"/left";
	}
	
	@RequestMapping(value="/{moduleName}/Main.action")
	public String moduleMain(@PathVariable String moduleName) {
		return moduleName+"/main";
	}
	
}
