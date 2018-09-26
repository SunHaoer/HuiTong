package cn.tarena.ht.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tarena.ht.pojo.Dept;
import cn.tarena.ht.service.DeptService;
import net.sf.json.JSONObject;

@Controller
public class DeptController {
	@Autowired
	private DeptService deptService;
	
	
	/**
	 * 根据实际的业务逻辑，在页面跳转时，先查询所有的列表信息
	 * @param model
	 * @return 部门显示列表
	 */
	@RequestMapping(value="/sysadmin/dept/list")
	public String toDeptList(Model model) {
		List<Dept> deptList = deptService.findAll();	//调用service层的findAll方法
		model.addAttribute("deptList", deptList);		//数据填充
		return "/sysadmin/dept/jDeptList";		//返回的页面路径和名称
	}
	
	/**
	 * 部门状态的停用
	 * @param deptIds
	 * @return
	 */
	@RequestMapping(value="/sysadmin/dept/stop")
	public String toStop(
			@RequestParam(value="deptId",defaultValue="0") String[] deptIds) {
		int state = 0;	//停用的状态
		deptService.updateState(deptIds, state);	//调用业务层的方法
		return "redirect:/sysadmin/dept/list";	//重定向了请求：list请求，相当于重新执行了一遍 toDeptList方法
	}
	
	/**
	 * 部门状态的启动
	 * @param deptIds
	 * @return
	 */
	@RequestMapping(value="/sysadmin/dept/start")
	public String toStart(
			@RequestParam(value="deptId",defaultValue="0") String[] deptIds) {
		int state = 1;		//启动的状态
		deptService.updateState(deptIds, state);		//调用业务层的方法
		return "redirect:/sysadmin/dept/list";
	}
	
	
	/**
	 * 批量删除
	 * @param deptIds
	 * @return
	 */
	@RequestMapping(value="/sysadmin/dept/delete")
	public String deleteDept(
			@RequestParam(value="deptId",defaultValue="0") String[] deptIds) {
		deptService.deleteDept(deptIds);
		return "redirect:/sysadmin/dept/list";
	}
	
	
	/**
	 * 点击新增按钮，实现页面跳转
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/sysadmin/dept/tosave")
	public String toSaveDept(Model model) {
		List<Dept> parentDeptList = deptService.findParentDept();		//准备 上级部门信息的数据
		model.addAttribute("parentDeptList", parentDeptList);		//数据填充
		return "/sysadmin/dept/jDeptSave";
	}
	
	/**
	 * 新增页面的保存方法
	 * @param dept
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/sysadmin/dept/save")
	public String saveDept(Dept dept , Model model) {
		String deptId = dept.getDeptId();
		if (deptId == null || "".equals(deptId)) {	//在执行插入方法之前，先教研数据是否存在
			return "forward:/sysadmin/dept/tosave";
		}
		Dept checkDept = deptService.findDeptById(deptId);
		if (checkDept != null) {//表示  存在主键冲突
			model.addAttribute("errorInfo", "该部门编号已存在");		//给出前端页面一个错误信息
			return "forward:/sysadmin/dept/tosave";		//使用转发：主要作用：把错误信息带入到页面中
		}
		deptService.saveDept(dept);
		return "redirect:/sysadmin/dept/list";
	}
	
	
	/**
	 * 点击修改按钮，实现页面的跳转
	 * @param deptId
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/sysadmin/dept/toupdate")
	public String toUpdateDept(String deptId,Model model) {
		Dept dept = deptService.findDeptBackById(deptId);	//数据的回显：需要自关联的查询
		List<Dept> parentDeptList = deptService.findParentDept();	//准备 上级部门信息的数据
		model.addAttribute("dept", dept);		//数据填充
		model.addAttribute("parentDeptList", parentDeptList);
		return "/sysadmin/dept/jDeptUpdate";
	}
	
	
	/**
	 * 点击更新页面，实现数据的更新
	 * @param dept
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/sysadmin/dept/update")
	public String updateDept(Dept dept,Model model) {
		String deptId = dept.getDeptId();
		if (deptId == null || "".equals(deptId)) {
			return "forward:/sysadmin/dept/tosave";
		}
		Dept checkDept = deptService.findDeptById(deptId);
		if (checkDept != null) {	// 表示存在主键冲突
			model.addAttribute("errorInfo", "该部门编号已存在");
			return "forward:/sysadmin/dept/tosave";
		}
		
		return "redirect:/sysadmin/dept/list";
	}
	
	/**
	 * ajax异步校验是否存在
	 * @param deptId
	 * @return
	 */
	@RequestMapping(value="/sysadmin/dept/checkDeptId")
	@ResponseBody  //把json对象放入到response中
	public JSONObject checkDeptId(String deptId) {
		System.out.println("haha");
		JSONObject jsonObject = new JSONObject();
		Dept dept = deptService.findDeptById(deptId);
		if(dept == null) {
			jsonObject.put("result", "false");
		} else {
			jsonObject.put("result", "true");
		}
		return jsonObject;
	}
	
}
