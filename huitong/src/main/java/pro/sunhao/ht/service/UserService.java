package pro.sunhao.ht.service;

import java.util.List;

import pro.sunhao.ht.pojo.User;
import pro.sunhao.ht.tool.PageBean;

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
	
	/**
	 * 检验用户的登录信息
	 * @param userName
	 * @param password
	 * @return
	 */
	public User checkLoginByUser(String userName, String password);

	/**
	 * 根据用户名查用户是否存在
	 * @return
	 */
	public boolean findUserByUsername(String username);
	
	/**
	 * 根据编号删除用户
	 * @param userIds
	 */
	public void deleteUserByUserId(String[] userIds);
	
	/**
	 * 根据用户id查询回显信息
	 * @param userId
	 * @return
	 */
	public User findUserByUserId(String userId);
	
	/**
	 * 更改用户使用状态
	 * @param userIds
	 * @param state
	 */
	public void updateUserState(String[] userIds, int state);
	
}
