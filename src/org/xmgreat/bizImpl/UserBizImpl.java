package org.xmgreat.bizImpl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.xmgreat.bean.UserBean;
import org.xmgreat.biz.UserBiz;
import org.xmgreat.mapper.UserMapper;
@Service
public class UserBizImpl implements UserBiz {
	@Resource
	private UserMapper userMapper;
	
	@Override
	public UserBean login(String username, String psw) {
		return userMapper.queryUser(username, psw);
	}

}
