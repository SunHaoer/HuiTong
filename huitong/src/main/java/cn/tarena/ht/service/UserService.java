package cn.tarena.ht.service;

import java.util.List;

import cn.tarena.ht.pojo.User;
import cn.tarena.ht.tool.PageBean;

public interface UserService {
	
	/**
	 * 查询所有用户
	 * @return
	 */
	public List<User> findAll();
	
	/**
	 * 查询总共的数据量(用于分页)
	 * @return
	 */
	public int getUserTotalCount();
	
	/**
	 * 根据分页查询用户
	 * @param startRow
	 * @param pageSize
	 * @return
	 */
	public PageBean<User> findUserByPages(int currentRow, int pageSize);
	
	/**
	 * 查询用户的上级
	 * @return
	 */
	public List<User> findManagerUser();
	
	/**
	 * 添加用户
	 * @param user
	 */
	public void saveUser(User user);
	
	/**
	 * 保存role到中间表
	 * @param userId
	 * @param roleIds
	 */
	public void saveUserRole(String userId, String roleIds);
	
	/**
	 * 根据userId查询所有已经勾选的信息
	 * @param userId
	 * @return
	 */
	public List<String> findUserRoleByUserId(String userId);
	
}
