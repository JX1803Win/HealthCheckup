package org.xmgreat.biz;

import java.util.List;

import org.springframework.web.servlet.ModelAndView;
import org.xmgreat.bean.CityBean;
import org.xmgreat.bean.ManagerBean;
import org.xmgreat.bean.PermissionsInfBean;
import org.xmgreat.bean.UserInfoBean;

public interface AdminBiz
{
	public ManagerBean login(String adminName, String psw);
	public  ModelAndView showUser(UserInfoBean userInfoBean);//用户管理
	public String  updateUserState (UserInfoBean userInfoBean);//修改用户状态
	public String  updateUserPwd (UserInfoBean userInfoBean);//修改用户密码
	public  ModelAndView showAdmin(ManagerBean managerBean);//后用户管理
	public String  updateAdminState (ManagerBean managerBean);//修改后台用户状态
	public String  updateAdminPwd (ManagerBean managerBean);//修改用户密码
	public  ModelAndView adminAdd();//查询注册下拉框的值
	public  List<CityBean> selectCity(CityBean tyBean);//查询注册下拉框的=======
	//通过角色ID查询权限ID
    public List<PermissionsInfBean> selectRoleInfo(Integer ruleId);

}
