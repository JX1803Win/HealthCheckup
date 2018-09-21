package org.xmgreat.biz;

import java.util.List;

import org.xmgreat.bean.RoleBean;


public interface RoleBiz {
      //查找所有角色
	  public List<RoleBean> selectAllRoleInfo(String rolename,int pageNo);
	  public int getRoleNum(String rolename);
}
