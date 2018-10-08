package pro.sunhao.ht.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pro.sunhao.ht.mapper.UserMapper;
import pro.sunhao.ht.pojo.User;
import pro.sunhao.ht.pojo.UserInfo;
import pro.sunhao.ht.tool.PageBean;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;
	
	@Override
	public List<User> findAll() {
		return userMapper.findAll();
	}

	@Override
	public int getUserTotalCount() {
		return userMapper.getUserTotalCount();
	}
	
	@Override
	public PageBean<User> findUserByPages(int currentPage, int pageSize) {		// 返回值：pageBean的对象，不只是List<User>
		PageBean<User> pageBean = new PageBean<User>();
		pageBean.setCurrPage(currentPage);		// 封装当前的页数
		pageBean.setPageSize(pageSize);		// 封装每一页的数量
		int totalCount = userMapper.getUserTotalCount();	// 封装用于的总数据量
		pageBean.setTotalCount(totalCount);
		int pages = (int)(Math.ceil(totalCount / pageSize) + 1.1); 	// 封装所有的页数
		pageBean.setTotalPage(pages);
		int startRow = pageSize * (currentPage - 1);		// 封装每一页显示的数据
		List<User> userList = userMapper.findUserByPages(startRow, pageSize);
		pageBean.setPageList(userList);
		return pageBean;
	}

	@Override
	public List<User> findManagerUser() {
		return userMapper.findManagerUser();
	}

	@Override
	public void saveUser(User user) {
		String userId = UUID.randomUUID().toString();		// 自动生成主键
		user.setUserId(userId);		// 保存到user_p中
		userMapper.saveUser(user);
		UserInfo userInfo = user.getUserInfo();		// 保存到user_info_p中
		userInfo.setUserInfoId(user.getUserId());
		user.setUserInfo(userInfo);
//for(int i = 0; i < 10; i++) System.out.println();
//System.out.println(userInfo);
		userMapper.saveUserInfo(userInfo);
	}

	@Override
	public void saveUserRole(String userId, String roleIds) {
		//userMapper.deleteUserRole(userId); 		// 防止数据重复提交，删除原数据
		String[] roles = roleIds.split(",");	// roleIds为多个roleId的拼接字符串
		for(String roleId : roles) {
			userMapper.saveUserRole(userId, roleId);
		}
		
	}

	@Override
	public List<String> findUserRoleByUserId(String userId) {
		return userMapper.findUserRoleByUserId(userId);
	}

	@Override
	public User checkLoginByUser(String userName, String password) {
		return userMapper.checkLoginByUser(userName, password);
	}

	@Override
	public boolean findUserByUsername(String username) {
		if(userMapper.findUserByUsername(username) == null) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void deleteUserByUserId(String[] userIds) {
		for(String userId : userIds) {
			userMapper.deleteUserByUserId(userId);
			userMapper.deleteUserInfoByUserId(userId);
			//userMapper.deleteUserRoleById(userId);
		}
	}

	@Override
	public User findUserByUserId(String userId) {
		User user = userMapper.findUserByUserId(userId);
		//user.setUserId(user.getUserInfo().getUserInfoId());
		user.setUsername(user.getUserInfo().getName());
		return user;
	}

	@Override
	public void updateUserState(String[] userIds, int state) {
			userMapper.updateUserState(userIds, state);			
	}
}
