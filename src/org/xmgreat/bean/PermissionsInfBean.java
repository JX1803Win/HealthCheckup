package org.xmgreat.bean;

public class PermissionsInfBean {//权限信息表
      private Integer permissionsId;//权限ID
      private String menuName;//菜单名称
      private Integer preMenu;//上级菜单ID
      private String urlAddress;//url地址
      private Integer orderNo;//排序号
      private RolePermissionsBean rolePermissionsBean;//角色关系bean
      public PermissionsInfBean() {
		// TODO Auto-generated constructor stub
	}
	
	

	public PermissionsInfBean(Integer permissionsId, String menuName, Integer preMenu, String urlAddress,
			Integer orderNo, RolePermissionsBean rolePermissionsBean) {
		super();
		this.permissionsId = permissionsId;
		this.menuName = menuName;
		this.preMenu = preMenu;
		this.urlAddress = urlAddress;
		this.orderNo = orderNo;
		this.rolePermissionsBean = rolePermissionsBean;
	}



	public RolePermissionsBean getRolePermissionsBean() {
		return rolePermissionsBean;
	}



	public void setRolePermissionsBean(RolePermissionsBean rolePermissionsBean) {
		this.rolePermissionsBean = rolePermissionsBean;
	}



	public Integer getPermissionsId() {
		return permissionsId;
	}
	public void setPermissionsId(Integer permissionsId) {
		this.permissionsId = permissionsId;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public String getUrlAddress() {
		return urlAddress;
	}
	public void setUrlAddress(String urlAddress) {
		this.urlAddress = urlAddress;
	}
	public Integer getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(Integer orderNo) {
		this.orderNo = orderNo;
	}

	public Integer getPreMenu() {
		return preMenu;
	}

	public void setPreMenu(Integer preMenu) {
		this.preMenu = preMenu;
	}
      
}
