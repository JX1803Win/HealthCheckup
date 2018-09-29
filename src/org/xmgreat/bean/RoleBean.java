package org.xmgreat.bean;

import org.springframework.stereotype.Repository;

@Repository
public class RoleBean {//角色表
      private Integer roleId;//角色ID
      private String roleName;//角色名
      private RolePermissionsBean rolePermissionsBean;//角色权限关系
      private PermissionsInfBean permissionsInfBean;//权限信息
      public RoleBean() {
		// TODO Auto-generated constructor stub
	}
	
	
    
	public RoleBean(Integer roleId, String roleName, RolePermissionsBean rolePermissionsBean,
			PermissionsInfBean permissionsInfBean) {
		super();
		this.roleId = roleId;
		this.roleName = roleName;
		this.rolePermissionsBean = rolePermissionsBean;
		this.permissionsInfBean = permissionsInfBean;
	}

    

	public PermissionsInfBean getPermissionsInfBean() {
		return permissionsInfBean;
	}



	public void setPermissionsInfBean(PermissionsInfBean permissionsInfBean) {
		this.permissionsInfBean = permissionsInfBean;
	}



	public RolePermissionsBean getRolePermissionsBean() {
		return rolePermissionsBean;
	}

	public void setRolePermissionsBean(RolePermissionsBean rolePermissionsBean) {
		this.rolePermissionsBean = rolePermissionsBean;
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

