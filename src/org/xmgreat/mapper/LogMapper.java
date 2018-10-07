package org.xmgreat.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.xmgreat.bean.LogBean;

/**
 * @author 周鸿谊
 * @date 2018年10月2日
 * @description 日志
 */

@Repository
public interface LogMapper
{
	public Integer addLog(LogBean logBean);

	public Integer delLog(@Param("logId") Integer logId);

	public List<LogBean> getLogs(Map<String, Object> condition);

	/**
	 * @description 计算条件查询日志总数
	 * @param userName 用户名称
	 * @return 日志总数
	 */
	public Integer count(@Param("adminName") String adminName);

}
