package cn.tarena.ht.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import cn.tarena.ht.mapper.ModuleMapper;
import cn.tarena.ht.pojo.Module;

@Service
public class ModuleServiceImpl implements ModuleService {
	
	@Autowired
	private ModuleMapper modulemapper;

	@Override
	public List<Module> findAll() {
		return modulemapper.findAll();
	}

	@Override
	public List<Model> findParentModule() {
		return modulemapper.findParentModule();
	}

	@Override
	public void saveModule(Module module) {
		String moduleId =  UUID.randomUUID().toString();
		module.setModuleId(moduleId);
		modulemapper.saveModule(module);
	}

}
