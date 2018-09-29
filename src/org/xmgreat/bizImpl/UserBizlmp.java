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
	public UserInfoBean checkPhone(Long phone)
	{
		// TODO Auto-generated method stub
		return userMapper.checkPhone(phone);
	}

	@Override
	public void reg(String username, Long phone, String pwd)
	{
		// TODO Auto-generated method stub
		userMapper.reg(username, phone, pwd);
	}

	@Override
	public void forGotPwd(Long phone, String pwd)
	{
		// TODO Auto-generated method stub
		userMapper.forGotPwd(phone, pwd);
	}

	@Override
	public void changeInfo(String sex, int age, String birth, String blood, String add, Long phone)
	{
		// TODO Auto-generated method stub
		userMapper.changeInfo(sex, age, birth, blood, add, phone);
	}

}
