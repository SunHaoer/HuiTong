package pro.sunhao.ht.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import pro.sunhao.ht.pojo.Dept;

public interface DeptMapper {
	
	/**
	 * 查询所有部门
	 * @return
	 */
	public List<Dept> findAll();
	
	/**
	 * 状态的启动和停用
	 * @param deptIds		使用注解@Param的形式对map集合进行封装
	 * @param state
	 */
	public void updateState(
			@Param(value="deptIds") String[] deptIds,
			@Param(value="state") int state);
	
	/**
	 * 批量删除
	 * @param deptIds
	 */
	public void deleteDept(String[] deptIds) ;

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
	
	/**
	 * 部门的分页查询
	 * @param currentPage
	 * @param pageSize
	 * @return
	 */
	public List<Dept> findDeptByPages(
			@Param(value="startRow") int startRow, 
			@Param(value="pageSize") int pageSize);
	
	/**
	 * 查询数据量
	 * @return
	 */
	public int getDeptTotalCount();
}
