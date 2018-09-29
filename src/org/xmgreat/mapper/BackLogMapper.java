package org.xmgreat.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.xmgreat.bean.ManagerBean;

@Repository
public interface BackLogMapper
{
	// 验证后台登入
	public ManagerBean checkBackLog(@Param("managername") String name, @Param("password") String password);
}
