package org.xmgreat.bizImpl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.xmgreat.bean.ManagerBean;
import org.xmgreat.biz.AdminBiz;
import org.xmgreat.mapper.AdminMapper;

@Service
public class AdminBizImpl implements AdminBiz
{
	@Resource
	private AdminMapper adminMapper;

	@Override
	public ManagerBean login(String adminName, String psw)
	{
		// TODO Auto-generated method stub
		return adminMapper.adminLogin(adminName, psw);
	}

}
