package org.xmgreat.bizImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.xmgreat.bean.ManagerBean;
import org.xmgreat.bean.PermissionsInfBean;
import org.xmgreat.bean.RoleBean;
import org.xmgreat.bean.RolePermissionsBean;
import org.xmgreat.biz.RoleBiz;
import org.xmgreat.mapper.ParamMapper;
import org.xmgreat.mapper.PermissionsMapper;
@Component
public class RoleBizImpl implements RoleBiz {

	@Resource
	private PermissionsMapper permissionsMapper;

	@Override
	public List<RoleBean> selectAllRoleInfo(String roleName,int pageNo) {
		// TODO Auto-generated method stub	
		List<RoleBean> list=permissionsMapper.selectAllRoleInfo(roleName, pageNo);
		return list;
	}

	@Override
	public int getRoleNum(String roleName) {
		// TODO Auto-generated method stub
		int size=permissionsMapper.getRoleNum(roleName);
		return size;
	}

	@Override
	public void delRole(int roleId) {
		// TODO Auto-generated method stub
		permissionsMapper.delRole(roleId);
	}

	@Override
	public void delManageRole(int roleId) {
		// TODO Auto-generated method stub
		permissionsMapper.delManageRole(roleId);
	}

	@Override
	public void deltblRulePermissions(int roleId) {
		// TODO Auto-generated method stub
		permissionsMapper.deltblRulePermissions(roleId);
	}

	@Override
	public void addRole(String roleName) {
		// TODO Auto-generated method stub
		 permissionsMapper.addRole(roleName);
	}

	@Override
	public void updateRole(int roleId, String roleName) {
		// TODO Auto-generated method stub
		permissionsMapper.updateRole(roleId,roleName);
	}

	@Override
	public List<PermissionsInfBean> selectAllMenu() {
		// TODO Auto-generated method stub
		return permissionsMapper.selectAllMenu();
	}

	@Override
	public List<PermissionsInfBean> selectAllFMenu() {
		// TODO Auto-generated method stub
		return permissionsMapper.selectAllFMenu();
	}

	@Override
	public List<PermissionsInfBean> selectAllMenuRole(String roleName) {
		// TODO Auto-generated method stub
		return permissionsMapper.selectAllMenuRole(roleName);
	}

	@Override
	public List<PermissionsInfBean> selectAllFMenuRole(String roleName) {
		// TODO Auto-generated method stub
		return permissionsMapper.selectAllFMenuRole(roleName);
	}

	@Override
	public PermissionsInfBean selectAllPer(String menuName) {
		// TODO Auto-generated method stub
		return permissionsMapper.selectAllPer(menuName);
	}

	@Override
	public int selectRoleId(String roleName) {
		// TODO Auto-generated method stub
		return permissionsMapper.selectRoleId(roleName);
	}

	@Override
	public void delRolePermissions(int roleId) {
		// TODO Auto-generated method stub
		permissionsMapper.delRolePermissions(roleId);
	}

	@Override
	public void addRolePermissions(List<PermissionsInfBean> pbList, int roleId) {
		// TODO Auto-generated method stub
		for (int i = 0; i < pbList.size(); i++) {
			permissionsMapper.addRolePermissions(pbList.get(i).getPermissionsId(),roleId);
			//判断数据库中父类权限是否已经存在
			RolePermissionsBean rpb=permissionsMapper.selectFPer(pbList.get(i).getPreMenu(),roleId);
			if (rpb==null) {
				permissionsMapper.addRolePermissions(pbList.get(i).getPreMenu(),roleId);
			}
		}
	}

	@Override
	public int getMenuNum(String menuName) {
		// TODO Auto-generated method stub
		return permissionsMapper.getMenuNum(menuName);
	}

	@Override
	public List<PermissionsInfBean> selectAllMenuInfo(String menuName,int pageNo) {
		// TODO Auto-generated method stub
		return permissionsMapper.selectAllMenuInfo(menuName,pageNo);
	}

	@Override
	public void addFMenu(String menuName) {
		// TODO Auto-generated method stub
		permissionsMapper.addFMenu(menuName);
	}

	@Override
	public void updateFMenu(int permissionsId, String menuName) {
		// TODO Auto-generated method stub
		permissionsMapper.updateFMenu(permissionsId, menuName);
	}



	@Override
	public void delPerInfMenu(int permissionsId) {
		// TODO Auto-generated method stub
		permissionsMapper.delPerInfMenu(permissionsId);
	}

	@Override
	public void deltblRolePer(int permissionsId) {
		// TODO Auto-generated method stub
		List<RolePermissionsBean> list=permissionsMapper.selectPermissionsMapper(permissionsId);
		if (list!=null) {
			permissionsMapper.deltblRolePer(permissionsId);
		}
		
	}

	@Override
	public void delPerInfAllMenu(int permissionsId) {
		// TODO Auto-generated method stub
		permissionsMapper.delPerInfAllMenu(permissionsId);
	}

	@Override
	public int getSonMenuNum(int permissionsId,String menuName) {
		// TODO Auto-generated method stub
		return permissionsMapper.getSonMenuNum(permissionsId,menuName);
	}

	@Override
	public List<PermissionsInfBean> selectAllSonMenuInfo(int permissionsId, int pageNo,String menuName) {
		// TODO Auto-generated method stub
		return permissionsMapper.selectAllSonMenuInfo(permissionsId, pageNo,menuName);
	}

	@Override
	public void addSMenu(Integer preMenu,String menuName, String url) {
		// TODO Auto-generated method stub
		permissionsMapper.addSMenu(preMenu,menuName, url);
	}

	@Override
	public void updateSMenu(Integer upmenuId, String upmenuName, String upurlAddress) {
		// TODO Auto-generated method stub
		permissionsMapper.updateSMenu(upmenuId, upmenuName, upurlAddress);
	}

	@Override
	public int selectAllFMenus(Integer permissionsId) {
		// TODO Auto-generated method stub
		return permissionsMapper.selectAllFMenus(permissionsId);
	}

	@Override
	public boolean selectRoleAlive(String roleName) {
		// TODO Auto-generated method stub
		RoleBean rBean=permissionsMapper.selectRoleAlive(roleName);
		if (rBean==null) {
			return true;
		}else {
			return false;
		}		
	}

	@Override
	public boolean selectMenuAlive(String menuName) {
		// TODO Auto-generated method stub
		PermissionsInfBean pInfBean=permissionsMapper.selectMenuAlive(menuName);
		if (pInfBean==null) {
			return true;
		}else {
			return false;
		}
	}
	
	

}
