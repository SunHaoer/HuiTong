package pro.sunhao.ht.service;

import java.util.List;

import org.springframework.ui.Model;

import pro.sunhao.ht.pojo.Module;

public interface ModuleService {
	
	/**
	 * 查询所有模块
	 * @return
	 */
	public List<Module> findAll();
	
	/**
	 * 准备上级部门
	 * @return
	 */
	public List<Model> findParentModule();
	
	/**
	 * 保存角色的模块信息
	 * @param module
	 */
	public void saveModule(Module module);
	
	/**
	 * 根据id查询已勾选的模块
	 * @param roleId
	 * @return
	 */
	public List<String> findRoleModuleByRoleId(String roleId);

}
