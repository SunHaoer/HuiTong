package cn.tarena.ht.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tarena.ht.mapper.UserMapper;
import cn.tarena.ht.pojo.User;
import cn.tarena.ht.pojo.UserInfo;
import cn.tarena.ht.tool.PageBean;

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
	
	// 返回值：pageBean的对象，不只是List<User>
	@Override
	public PageBean<User> findUserByPages(int currentPage, int pageSize) {
		for(int i = 0; i < 10; i++) System.out.println();
		System.out.println(currentPage + " " + pageSize);
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
		userMapper.saveUserInfo(userInfo);
	}

}
