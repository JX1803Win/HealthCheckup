package org.xmgreat.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.xmgreat.bean.ManagerBean;

@Repository
public interface AdminMapper
{
	/**
	 * @description 按用户名和密码查找用户
	 * @param adminName 管理员名
	 * @param psw       密码
	 * @return 管理员
	 */
	public ManagerBean adminLogin(@Param("adminName") String adminName, @Param("psw") String psw);

}
