package org.xmgreat.biz;

import org.xmgreat.bean.UserBean;

/**
 * @author 宋卓伟
 * @date 2018年9月15日
 * @description 用户业务接口
 */
public interface UserBiz {
	/**
	 * @description 用户登陆
	 * @param username 用户名
	 * @param psw 密码
	 * @return 用户
	 */
	public UserBean login(String username, String psw);
	
}
