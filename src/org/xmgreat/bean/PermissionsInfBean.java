package org.xmgreat.bean;

public class PermissionsInfBean {//权限信息表
      private Integer permissionsId;
      private String menuName;
      private String preMenu;
      private String urlAddress;
      private Integer orderNo;//排序号
      public PermissionsInfBean() {
		// TODO Auto-generated constructor stub
	}
	public PermissionsInfBean(Integer permissionsId, String menuName, String preMenu, String urlAddress,
			Integer orderNo) {
		super();
		this.permissionsId = permissionsId;
		this.menuName = menuName;
		this.preMenu = preMenu;
		this.urlAddress = urlAddress;
		this.orderNo = orderNo;
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
	public String getPreMenu() {
		return preMenu;
	}
	public void setPreMenu(String preMenu) {
		this.preMenu = preMenu;
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
      
}
