package cn.tarena.ht.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.ui.Model;

import cn.tarena.ht.pojo.Module;

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
	
}
