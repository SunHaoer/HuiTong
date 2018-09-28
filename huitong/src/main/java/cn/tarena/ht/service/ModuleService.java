package cn.tarena.ht.service;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.springframework.ui.Model;

import cn.tarena.ht.pojo.Module;

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
	
	public void saveModule(Module module);

}
