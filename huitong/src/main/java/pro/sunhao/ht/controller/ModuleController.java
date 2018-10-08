package pro.sunhao.ht.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import pro.sunhao.ht.pojo.Module;
import pro.sunhao.ht.service.ModuleService;

@Controller
@RequestMapping(value="/sysadmin/module")
public class ModuleController {
	
	@Autowired
	private ModuleService moduleService;

	/**
	 * 查看全部角色的页面跳转
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/list")
	public String toModuleList(Model model) {
		List<Module> moduleList = moduleService.findAll();
		model.addAttribute("moduleList", moduleList);
		return "/sysadmin/module/jModuleList";
	}
	
	/**
	 * 打开添加模块登记表
	 * @param module
	 * @return
	 */
	@RequestMapping(value="/tosave")
	public String toSaveModule(Model model, Module module) {
		// 准备上级模块
		List<Model> parentModuleList = moduleService.findParentModule();
		model.addAttribute("parentModuleList", parentModuleList);
		return "/sysadmin/module/jModuleSave";
	}
	
	/**
	 * 保存新添加的模块
	 * @param module
	 * @return
	 */
	@RequestMapping(value="/save")
	public String saveModule(Module module) {
		moduleService.saveModule(module);
		return "redirect:/sysadmin/module/list";
	}
}
