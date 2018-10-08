package pro.sunhao.ht.mapper;

import java.util.List;

import org.springframework.ui.Model;

import pro.sunhao.ht.pojo.Module;

public interface ModuleMapper {
	
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
	 * 保存新添加的模块
	 * @param module
	 */
	public void saveModule(Module module);
	
	/**
	 * 根据角色id查已勾选的角色模块
	 * @param roleId
	 * @return
	 */
	public List<String> findRoleModuleByRoleId(String roleId);
	
}
