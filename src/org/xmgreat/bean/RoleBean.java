package org.xmgreat.bean;

import org.springframework.stereotype.Repository;

@Repository
public class RoleBean {//角色表
      private Integer roleId;//角色ID
      private String roleName;//角色名
      public RoleBean() {
		// TODO Auto-generated constructor stub
	}
	public RoleBean(Integer roleId, String roleName) {
		super();
		this.roleId = roleId;
		this.roleName = roleName;
	}
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
      
}

