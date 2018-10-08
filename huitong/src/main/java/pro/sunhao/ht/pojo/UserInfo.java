package pro.sunhao.ht.pojo;

import java.util.Date;

public class UserInfo extends BaseEntity {
	
	private String userInfoId;
	private String name;
	private String cardNo;
	private String managerId;
	private Date joinDate;
	// 自关联描述
	private UserInfo managerInfo;	// 上级领导
	private Double salary;
	private Date birthday;
	private String gender;
	private String station;
	private String telephone;
	private String userLevel;
	private String remark;
	private Integer orderNo;
	private User manager;
	
	public Date getBirthday() {
		return birthday;
	}
	
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getUserInfoId() {
		return userInfoId;
	}

	public void setUserInfoId(String userInfoId) {
		this.userInfoId = userInfoId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public String getManagerId() {
		return managerId;
	}

	public void setManagerId(String managerId) {
		this.managerId = managerId;
	}

	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}

	public UserInfo getManagerInfo() {
		return managerInfo;
	}

	public void setManagerInfo(UserInfo managerInfo) {
		this.managerInfo = managerInfo;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getStation() {
		return station;
	}

	public void setStation(String station) {
		this.station = station;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getUserLevel() {
		return userLevel;
	}

	public void setUserLevel(String userLevel) {
		this.userLevel = userLevel;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(Integer orderNo) {
		this.orderNo = orderNo;
	}

	public User getManager() {
		return manager;
	}

	public void setManager(User manager) {
		this.manager = manager;
	}

	@Override
	public String toString() {
		return "UserInfo [userInfoId=" + userInfoId + ", name=" + name + ", cardNo=" + cardNo + ", managerId="
				+ managerId + ", joinDate=" + joinDate + ", managerInfo=" + managerInfo + ", salary=" + salary
				+ ", birthday=" + birthday + ", gender=" + gender + ", station=" + station + ", telephone=" + telephone
				+ ", userLevel=" + userLevel + ", remark=" + remark + ", orderNo=" + orderNo + ", manager=" + manager
				+ "]";
	}
	
}
