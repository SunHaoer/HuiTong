package cn.tarena.ht.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tarena.ht.mapper.DeptMapper;
import cn.tarena.ht.pojo.Dept;
import cn.tarena.ht.tool.PageBean;

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

	@Override
	public PageBean<Dept> findDeptByPages(int currentPage, int pageSize) {
		PageBean<Dept> pageBean = new PageBean<Dept>();
		pageBean.setCurrPage(currentPage);		// 封装当前的页数
		pageBean.setPageSize(pageSize);		// 封装每一页的数量
		int totalCount = deptMapper.getDeptTotalCount();	// 封装用于的总数据量
		pageBean.setTotalCount(totalCount);
		int pages = (int)(Math.ceil(totalCount / pageSize) + 1.1); 	// 封装所有的页数
		pageBean.setTotalPage(pages);
		int startRow = pageSize * (currentPage - 1);		// 封装每一页显示的数据
//for(int i = 0; i < 5; i++) System.out.println();
		List<Dept> deptList = deptMapper.findDeptByPages(startRow, pageSize);
		pageBean.setPageList(deptList);
		return pageBean;
	}

}
