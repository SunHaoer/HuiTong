package pro.sunhao.ht.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import pro.sunhao.ht.pojo.User;
import pro.sunhao.ht.pojo.UserInfo;

public interface UserMapper {
	
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
	public List<User> findUserByPages(
			@Param(value="startRow") int startRow,
			@Param(value="pageSize") int pageSize);
	
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
	 * 添加用户详情
	 * @param userInfo
	 */
	public void saveUserInfo(UserInfo userInfo);
	
	/**
	 * 为用户添加角色，在role_user_p表中插入信息
	 * @param userId
	 * @param roleId
	 */
	public void saveUserRole(
			@Param(value="userId") String userId,
			@Param(value="roleId") String roleId);
	
	/**
	 * 根据userid删除中间表信息
	 * @param userId
	 */
	public void deleteUserRoleById(String userId);
	
	/**
	 * 根据userId查询所有已经勾选的信息
	 * @param userId
	 * @return
	 */
	public List<String> findUserRoleByUserId(String userId);
	
	/**
	 * 
	 * @param userName
	 * @param password
	 * @return
	 */
	public User checkLoginByUser(
			@Param(value="userName") String userName, 
			@Param(value="password") String password);
	
	/**
	 * 根据用户名查用户
	 * @param username
	 * @return
	 */
	public User findUserByUsername(String username);
	
	/**
	 * 根据id删除用户
	 * @param userId
	 */
	public void deleteUserByUserId(String userId);
	
	/**
	 * 根据id删除用户详细信息
	 * @param userId
	 */
	public void deleteUserInfoByUserId(String userId);
	
	/**
	 * 根据id查用户回显信息
	 * @param userId
	 */
	public User findUserByUserId(String userId);
	
	/**
	 * 更改用户使用状态
	 * @param userIds
	 * @param state
	 */
	public void updateUserState(
			@Param(value="userIds") String[] userIds,
			@Param(value="state") int state);
	
}
