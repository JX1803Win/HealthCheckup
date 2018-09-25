package org.xmgreat.bizImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.xmgreat.bean.UserInfoBean;
import org.xmgreat.biz.UserBiz;
import org.xmgreat.mapper.UserMapper;

@Service
public class UserBizlmp implements UserBiz
{
	@Resource
	private UserMapper userMapper;

	@Override
	public List<UserInfoBean> checkUser(Long phone, String pwd)
	{
		// TODO Auto-generated method stub
		return userMapper.checkUser(phone, pwd);
	}

	
	


	

	

	@Override
	public void reg(String username, Long phone, String pwd)
	{
		// TODO Auto-generated method stub
		userMapper.reg(username, phone, pwd);
	}

}
