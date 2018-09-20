package org.xmgreat.biz;

import java.util.List;

import org.xmgreat.bean.UserInfoBean;

public interface UserBiz
{
	public List<UserInfoBean> checkUser(Long phone,String pwd);

}
