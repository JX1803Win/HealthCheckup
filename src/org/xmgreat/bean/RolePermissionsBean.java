package org.xmgreat.bean;

import java.util.List;

public class RolePermissionsBean {
      private Integer roleId;//角色ID
      private Integer permissionsId;//权限ID
      private List<PermissionsInfBean> pibList;//角色权限
      public RolePermissionsBean() {
		// TODO Auto-generated constructor stub
	}
	public RolePermissionsBean(Integer roleId, Integer permissionsId, List<PermissionsInfBean> pibList) {
		super();
		this.roleId = roleId;
		this.permissionsId = permissionsId;
		this.pibList = pibList;
	}
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	public Integer getPermissionsId() {
		return permissionsId;
	}
	public void setPermissionsId(Integer permissionsId) {
		this.permissionsId = permissionsId;
	}
	public List<PermissionsInfBean> getPibList() {
		return pibList;
	}
	public void setPibList(List<PermissionsInfBean> pibList) {
		this.pibList = pibList;
	}
	
      
}