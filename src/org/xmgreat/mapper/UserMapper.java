package org.xmgreat.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.xmgreat.bean.UserBean;
@Repository
public interface UserMapper {
	
	/**
	 * @description 按用户名和密码查找用户
	 * @param username 用户名
	 * @param psw 密码
	 * @return 用户
	 */
	public UserBean queryUser(@Param("username")String username, @Param("psw")String psw);
	
}
