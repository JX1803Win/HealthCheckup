package org.xmgreat.bean;

import org.springframework.stereotype.Repository;

@Repository
public class PermissionsInfBean {//权限信息表
      private Integer permissionsId;//权限ID
      private String menuName;//菜单名称
      private String preMenu;//上级菜单
      private String urlAddress;//url地址
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
