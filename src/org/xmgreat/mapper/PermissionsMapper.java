package org.xmgreat.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.xmgreat.bean.PermissionsInfBean;
import org.xmgreat.bean.RoleBean;
import org.xmgreat.bean.RolePermissionsBean;
@Repository
public interface PermissionsMapper {
	
	public List<PermissionsInfBean> selectRoleInfo(Integer roleId);
	public List<RoleBean> selectAllRoleInfo(@Param("roleName")String roleName,@Param("pageNo")int pageNo);
	public int getRoleNum(@Param("roleName")String roleName);
	public void delManageRole(@Param("roleId")int roleId);
	public void delRole(@Param("roleId")int roleId);
	public void deltblRulePermissions(@Param("roleId")int roleId);
	public void addRole(@Param("roleName")String roleName);
	public void updateRole(@Param("roleId")int roleId,@Param("roleName")String roleName);
	public List<PermissionsInfBean> selectAllMenu();//查询所有的菜单
	public List<PermissionsInfBean> selectAllFMenu();//查询所有的父类菜单
	public List<PermissionsInfBean> selectAllMenuRole(@Param("roleName")String roleName);//查询id下的所有菜单
	public List<PermissionsInfBean> selectAllFMenuRole(@Param("roleName")String roleName);//查询id下的所有父类菜单
	public PermissionsInfBean selectAllPer(@Param("menuName")String menuName);//查询所有账户对应所有权限
	public int selectRoleId(@Param("roleName")String roleName);
	public void delRolePermissions(@Param("roleId")int roleId);//删除id权限
    public void addRolePermissions(@Param("permissionsId")int permissionsId,@Param("roleId")int roleId);
    public RolePermissionsBean selectFPer(@Param("permissionsId")int permissionsId,@Param("roleId")int roleId);
    public int getMenuNum(@Param("menuName")String menuName);//查询菜单数量
    public List<PermissionsInfBean> selectAllMenuInfo(@Param("menuName")String menuName,@Param("pageNo")int pageNo);//查询菜单
    public void addFMenu(@Param("menuName")String menuName);//添加父类菜单
    public void updateFMenu(@Param("permissionsId")int permissionsId,@Param("menuName")String menuName);//修改父类菜单
    public void deltblRolePer(@Param("permissionsId")int permissionsId);//删除父类菜单
    public void delPerInfMenu(@Param("permissionsId")int permissionsId);//删除父类菜单
    public void delPerInfAllMenu(@Param("permissionsId")int permissionsId);//删除父类下的所有子类菜单
    public int getSonMenuNum(@Param("permissionsId")int permissionsId,@Param("menuName")String menuName);//查找子菜单总数
    public List<PermissionsInfBean> selectAllSonMenuInfo(@Param("permissionsId")int permissionsId ,@Param("pageNo")int pageNo,@Param("menuName")String menuName);//查询子菜单
    public List<RolePermissionsBean> selectPermissionsMapper(@Param("permissionsId")int permissionsId);//查询权限关系表中是否有数据
    public void addSMenu(@Param("preMenu")Integer preMenu,@Param("menuName")String menuName,@Param("urlAddress")String urlAddress);//添加子类菜单
    public void updateSMenu(@Param("permissionsId")Integer permissionsId,@Param("menuName")String menuName,@Param("urlAddress")String urlAddress);//修改子菜单
    public int  selectAllFMenus(@Param("permissionsId")Integer permissionsId);
    public RoleBean selectRoleAlive(@Param("roleName")String roleName);//查询角色是否存在
    public PermissionsInfBean selectMenuAlive(@Param("menuName")String menuName);
}
