package org.xmgreat.biz;

import java.util.List;

import org.xmgreat.bean.ProjectBean;
import org.xmgreat.bean.SetmealBean;
import org.xmgreat.bean.UserAccoutBean;
import org.xmgreat.bean.UserInfoBean;

public interface UserBiz
{
	public List<UserInfoBean> checkUser(Long phone,String pwd);
	public UserInfoBean checkPhone(Long phone);
	public void reg(String username,Long phone,String pwd);
	public void forGotPwd(Long phone,String pwd);
	public void changeInfo(String sex,int age,String birth,String blood,String add,Long phone);
	public List<UserAccoutBean> getAccout(int userid,int page);
	public List<SetmealBean> getSetmeal(int page);
	public List<ProjectBean> getxi(int mid);
}
