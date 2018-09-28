package cn.tarena.ht.pojo;


public class Module extends BaseEntity {
	
	private String moduleId;
	private String name;
	private Integer ctype;
	private Integer state;
	private Integer orderNo;
	private String remarks;
	private Module parentModule;		// 自关联
	
	private String id;
	private String pid;
	private boolean checked;
	
	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	public String getModuleId() {
		return moduleId;
	}
	
	public void setModuleId(String moduleId) {
		this.moduleId = moduleId;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Integer getCtype() {
		return ctype;
	}
	
	public void setCtype(Integer ctype) {
		this.ctype = ctype;
	}
	
	public Integer getState() {
		return state;
	}
	
	public void setState(Integer state) {
		this.state = state;
	}
	
	public Integer getOrderNo() {
		return orderNo;
	}
	
	public void setOrderNo(Integer orderNo) {
		this.orderNo = orderNo;
	}
	
	public String getRemarks() {
		return remarks;
	}
	
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
	public Module getParentModule() {
		return parentModule;
	}
	
	public void setParentModule(Module parentModule) {
		this.parentModule = parentModule;
	}
	
	@Override
	public String toString() {
		return "module [moduleId=" + moduleId + ", name=" + name + ", ctype=" + ctype + ", state=" + state
				+ ", orderNo=" + orderNo + ", remark=" + remarks + ", parentModule=" + parentModule + "]";
	}
	
	
	
	
	
}
