package org.xmgreat.biz;

import java.util.Map;

/**
 * @author 周鸿谊
 * @date 2018年9月20日
 * @description 查看日志
 */
public interface LogBiz
{
	/**
	 * @description 带条件查询所有显示信息
	 * @param 查询条件
	 * @return 页面显示信息
	 */
	public Map<String, Object> search(Map<String, Object> condition);

	public void delLog(Integer logId);
	
	public void delLogs(Integer[] logId);
}
