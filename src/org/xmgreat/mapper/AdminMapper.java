package org.xmgreat.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.xmgreat.bean.ManagerBean;
import org.xmgreat.bean.UserInfoBean;

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
}
