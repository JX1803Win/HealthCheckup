package org.xmgreat.biz;

import java.util.List;

import org.xmgreat.bean.ManagerBean;

public interface BackLogBiz
{
	// 验证后台登入
		public ManagerBean checkBackLog(String name,String password);

}
