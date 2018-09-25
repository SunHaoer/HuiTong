package cn.tarena.ht.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tarena.ht.mapper.DeptMapper;
import cn.tarena.ht.pojo.Dept;

@Service
public class DeptServiceImpl implements DeptService {
	@Autowired
	private DeptMapper deptMapper;
	
	@Override
	public List<Dept> findAll() {
		return deptMapper.findAll();
	}

	@Override
	public void updateState(String[] deptIds, int state) {
		deptMapper.updateState(deptIds, state);
	}

	@Override
	public void deleteDept(String[] deptIds) {
		deptMapper.deleteDept(deptIds);
	}

	@Override
	public List<Dept> findParentDept() {
		return deptMapper.findParentDept();
	}

	@Override
	public void saveDept(Dept dept) {
		deptMapper.saveDept(dept);
	}

	@Override
	public Dept findDeptById(String deptId) {
		return deptMapper.findDeptById(deptId);
	}

	@Override
	public Dept findDeptBackById(String deptId) {
		return deptMapper.findDeptBackById(deptId);
	}

}
