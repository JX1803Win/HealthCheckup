package org.xmgreat.biz;

import java.util.List;

import org.xmgreat.bean.PermissionsInfBean;
import org.xmgreat.bean.RoleBean;


public interface RoleBiz {
      //查找所有角色
	  public List<RoleBean> selectAllRoleInfo(String rolename,int pageNo);
	  public int getRoleNum(String rolename);//获得角色数量
	  public void delManageRole(int roleId);
	  public void delRole(int roleId);//删除角色
	  public void deltblRulePermissions(int roleId);
	  public void addRole(String roleName);//添加角色
	  public void updateRole(int roleId,String roleName);//修改角色
	  public List<PermissionsInfBean> selectAllMenu();//查询所有的菜单
	  public List<PermissionsInfBean> selectAllFMenu();//查询所有的父类菜单
	  public List<PermissionsInfBean> selectAllMenuRole(String roleName);//查询id下的所有菜单
	  public List<PermissionsInfBean> selectAllFMenuRole(String roleName);//查询id下的所有父类菜单
	  public PermissionsInfBean selectAllPer(String menuName);//查询所有账户对应所有权限
      public int selectRoleId(String roleName);//查询角色Id
      public void delRolePermissions(int roleId);//删除id权限
      public void addRolePermissions(List<PermissionsInfBean> pbList,int roleId);

}
