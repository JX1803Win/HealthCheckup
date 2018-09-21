package org.xmgreat.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.xmgreat.bean.PermissionsInfBean;
import org.xmgreat.bean.RoleBean;
@Repository
public interface PermissionsMapper {
	
	public List<PermissionsInfBean> selectRoleInfo(Integer roleId);
	public List<RoleBean> selectAllRoleInfo(@Param("roleName")String roleName,@Param("pageNo")int pageNo);
	public int getRoleNum(@Param("roleName")String roleName);
}
