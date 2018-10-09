package org.xmgreat.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.xmgreat.bean.CityBean;
import org.xmgreat.bean.ManagerBean;
import org.xmgreat.bean.OfficeBean;
import org.xmgreat.bean.PhyCardBean;
import org.xmgreat.bean.ProjectBean;
import org.xmgreat.bean.Province;
import org.xmgreat.bean.RoleBean;
import org.xmgreat.bean.SetmealBean;
import org.xmgreat.bean.UserAccoutBean;
import org.xmgreat.bean.UserInfoBean;
import org.xmgreat.bean.UserPhyRecordBean;

@Repository
public interface AdminMapper
{
	/**
	 * @description 按用户名和密码查找用户
	 * @param adminName 管理员名
	 * @param psw       密码
	 * @return 管理员
	 */
	public ManagerBean adminLogin(@Param("adminName") String adminName, @Param("pwd") String psw);
	public List<UserInfoBean> showUser(UserInfoBean userInfoBean);//展示用户信息
	public int showUserCount(UserInfoBean userInfoBean);//查询总用户数量
	public boolean updateUserState(UserInfoBean userInfoBean);//修改用户状态
	public boolean updateUserPwd(UserInfoBean userInfoBean);//修改用户密码
	public List<ManagerBean> showAdmin(ManagerBean managerBean);//展示后台用户信息
	public int showAdminCount(ManagerBean managerBean);//查询总后台用户数量
	public boolean updateAdminState(ManagerBean managerBean);//修改后台用户状态
	public boolean updateAdminPwd(ManagerBean managerBean);//修改后台用户密码
	public List<OfficeBean> selectOffice();//展示后台科室
	public List<RoleBean> selectRole();//展示后台角色
	public List<CityBean> selectCity(CityBean cityBean);//展示城市
	public List<Province> selectProvince();//展示省份
	public int selectAdmin(ManagerBean managerBean);//查询用户知否以注册
	public boolean adminAdd(ManagerBean managerBean);//增加后台用户
	public List<PhyCardBean> showPhyCardInfo(PhyCardBean phyCardBean);//展示体检卡信息
	public int showPhyCardCount(PhyCardBean phyCardBean);//查询体检卡数量
	public boolean updatePhyCardState(PhyCardBean phyCardBean);//修改体检卡状态
	public List<UserInfoBean> phyCardManagement(UserInfoBean userInfoBean);//用户体检卡管理 
	public List<PhyCardBean> selectPhyCard();//展示体检卡信息
	public boolean applyCard(UserInfoBean userInfoBean);//办卡
	public boolean phyCardAdd(PhyCardBean phyCardBean);//增加体检卡号
	public int selectPhyCardId(PhyCardBean phyCardBean);//查询体检卡号否以注册
	public List<UserPhyRecordBean> selectPhysicaiInfo(UserPhyRecordBean userPhyRecordBean);//查询体检人信息和套餐名称
	public  List<SetmealBean> selectProjectInfo(Integer setmealId);//过套餐ID查显目信息
	public List<ProjectBean> selectProjectInfo2(Integer projectId);//查询体检人信息和显目信息
	public Double charge(Integer setmealId);//套餐总费用
	public UserAccoutBean selectBalance(Integer userId);//查出用户的最新余额和流水账信息
	public boolean addRecord(UserAccoutBean userAccoutBean);//增加流水记录
	public boolean closeAccount(Integer physicaiId);//修改成结算状态
	public List<UserAccoutBean> selectAccount(UserInfoBean userInfoBean);//查询体检人信息和显目信息
	public int selectAccountAll(UserInfoBean userInfoBean);//查询流水账总数
	public UserInfoBean selectUserInfo(UserInfoBean userInfoBean);//查出用户的最新余额和流水账信息
	public boolean regUser(UserInfoBean userInfoBean);//增加用户
	public int selectUser(UserInfoBean userInfoBean);//查询用户知否以注册
	
	
	
}
