package org.xmgreat.bizImpl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.xmgreat.bean.ManagerBean;

import org.xmgreat.biz.BackLogBiz;

import org.xmgreat.mapper.BackLogMapper;

@Service
public class BackLogImpl implements BackLogBiz
{
	@Resource
	private BackLogMapper backLogMapper;

	@Override
	public ManagerBean checkBackLog(String name, String password)
	{
		// TODO Auto-generated method stub
		return backLogMapper.checkBackLog(name, password);
	}

}
