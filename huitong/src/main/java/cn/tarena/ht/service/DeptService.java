package cn.tarena.ht.service;

import java.util.List;

import cn.tarena.ht.pojo.Dept;
import cn.tarena.ht.pojo.User;

public interface DeptService {
	/**
	 * 查询所有部门
	 * @return
	 */
	public List<Dept> findAll();
	
	/**
	 * 状态的启动和停止
	 * @param deptIds
	 * @param state
	 */
	public void updateState(String[] deptIds,int state);
	
	/**
	 * 批量删除
	 * @param deptIds
	 */
	public void deleteDept(String[] deptIds);
	
	/**
	 * 查询所有的上级部门
	 * @return
	 */
	public List<Dept> findParentDept();
	
	/**
	 * 插入一条部门信息
	 * @param dept
	 */
	public void saveDept(Dept dept);
	
	/**
	 * 根据id查询部门信息
	 * @param deptId
	 * @return
	 */
	public Dept findDeptById(String deptId);
	
	/**
	 * 修改页面的数据回显
	 * @param deptId
	 * @return
	 */
	public Dept findDeptBackById(String deptId);
	
}
