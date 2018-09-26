package cn.tarena.ht.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.tarena.ht.pojo.User;
import cn.tarena.ht.pojo.UserInfo;

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
	public void deleteUserRole(String userId);
	
	/**
	 * 根据userId查询所有已经勾选的信息
	 * @param userId
	 * @return
	 */
	public List<String> findUserRoleByUserId(String userId);
}
