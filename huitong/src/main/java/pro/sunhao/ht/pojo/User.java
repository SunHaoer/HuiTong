package pro.sunhao.ht.pojo;

public class User {
	
	private String userId;
	private String username;
	private String password;
	private Integer state;
	private Dept dept;		// 描述dept和user的从user角度的一对一关系
	private UserInfo userInfo;		// 描述userInfo和user的一对一关系

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Dept getDept() {
		return dept;
	}

	public void setDept(Dept dept) {
		this.dept = dept;
	}

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username + ", password=" + password + ", state=" + state
				+ ", dept=" + dept + ", userInfo=" + userInfo + "]";
	}
	
}
