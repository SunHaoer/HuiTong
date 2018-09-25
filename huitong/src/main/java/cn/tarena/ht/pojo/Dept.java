package cn.tarena.ht.pojo;

public class Dept extends BaseEntity{
	
	private String deptId;	//使用驼峰映射
	private String deptName;
	private Integer state;	// 部门的状态：0 停用  1 启动
	private Dept parentDept;	//自关联关系的描述：上级部门
	
	public String getDeptId() {
		return deptId;
	}
	
	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}
	
	public String getDeptName() {
		return deptName;
	}
	
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	
	public Integer getState() {
		return state;
	}
	
	public void setState(Integer state) {
		this.state = state;
	}
	
	public Dept getParentDept() {
		return parentDept;
	}
	
	public void setParentDept(Dept parentDept) {
		this.parentDept = parentDept;
	}
	
	@Override
	public String toString() {
		return "Dept [deptId=" + deptId + ", deptName=" + deptName + ", state=" + state + ", parentDept=" + parentDept
				+ "]";
	}
	
}
