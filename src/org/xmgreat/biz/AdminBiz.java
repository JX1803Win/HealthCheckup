package org.xmgreat.biz;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.xmgreat.bean.CityBean;
import org.xmgreat.bean.ManagerBean;
import org.xmgreat.bean.PermissionsInfBean;
import org.xmgreat.bean.PhyCardBean;
import org.xmgreat.bean.UserAccoutBean;
import org.xmgreat.bean.UserInfoBean;
import org.xmgreat.bean.UserPhyRecordBean;

public interface AdminBiz
{
	public List<PermissionsInfBean> selectRoleInfo(Integer roleId);
	public ManagerBean login(String adminName, String psw);
	public  ModelAndView showUser(UserInfoBean userInfoBean);//用户管理
	public String  updateUserState (UserInfoBean userInfoBean);//修改用户状态
	public String  updateUserPwd (UserInfoBean userInfoBean);//修改用户密码
	public  ModelAndView showAdmin(ManagerBean managerBean);//后用户管理
	public String  updateAdminState (ManagerBean managerBean);//修改后台用户状态
	public String  updateAdminPwd (ManagerBean managerBean);//修改用户密码
	public  ModelAndView adminAdd();//查询注册下拉框的值
	public  List<CityBean> selectCity(CityBean cityBean);//查询注册下拉框的城市
	public  List<ManagerBean> selectAdmin(ManagerBean managerBean);//查询用户知否以注册
	public String  addAdmin (ManagerBean managerBean);//增加用户
	public  ModelAndView showPhyCardInfo(PhyCardBean phyCardBean);//体检卡管理
	public String  updatePhyCardState (PhyCardBean phyCardBean);//修改体检卡状态
	public  ModelAndView phyCardManagement(UserInfoBean userInfoBean);//用户管理
	public  List<PhyCardBean> selectPhyCard();//查询已激活未用体检卡号
	public String  applyCard (UserInfoBean userInfoBean,PhyCardBean phyCardBean);//提交办卡
	public String  reportTheLossOf (UserInfoBean userInfoBean,PhyCardBean phyCardBean);//挂失
	public String  changeCard (UserInfoBean userInfoBean,PhyCardBean phyCardBean);//换卡
	public String  upFile (MultipartFile file);//增加卡
	public ModelAndView  selectProject (UserPhyRecordBean userPhyRecordBean);//项目收费信息
	public  List<CityBean> settleAccount(Double charge,Integer userId,Integer physicaiId);//结算
	public ModelAndView selectAccount(UserInfoBean userInfoBean);//流水账
	public String  topUp (UserAccoutBean userAccoutBean);//充值
	public  ModelAndView userAdd();//查询注册下拉框的值
	public String  regUser (UserInfoBean userInfoBean);//增加用户
	public  List<UserInfoBean> selectUser(UserInfoBean userInfoBean);//查询用户知否以注册
	public  List<UserInfoBean> refund(Double money, Integer userId);//退款
}
