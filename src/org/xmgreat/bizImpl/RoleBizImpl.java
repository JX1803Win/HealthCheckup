package org.xmgreat.bizImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.xmgreat.bean.ManagerBean;
import org.xmgreat.bean.RoleBean;
import org.xmgreat.biz.RoleBiz;
import org.xmgreat.mapper.ParamMapper;
import org.xmgreat.mapper.PermissionsMapper;
@Component
public class RoleBizImpl implements RoleBiz {

	@Resource
	private PermissionsMapper permissionsMapper;

	@Override
	public List<RoleBean> selectAllRoleInfo(String rolename,int pageNo) {
		// TODO Auto-generated method stub	
		List<RoleBean> list=permissionsMapper.selectAllRoleInfo(rolename, pageNo);
		return list;
	}

	@Override
	public int getRoleNum(String rolename) {
		// TODO Auto-generated method stub
		int size=permissionsMapper.getRoleNum(rolename);
		return size;
	}
	
	

}
