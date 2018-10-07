package org.xmgreat.bizImpl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.xmgreat.biz.LogBiz;
import org.xmgreat.mapper.LogMapper;
import org.xmgreat.util.Data;

@Service
public class LogBizImpl implements LogBiz
{
	@Resource
	private LogMapper logMapper;

	public Integer totalPage;
	public Integer total;
	private Map<String, Object> resultMap = new HashMap<String, Object>();

	@Override
	public Map<String, Object> search(Map<String, Object> condition)
	{
		String adminName = null;
		if (condition.get("adminName") != null)
		{
			adminName = condition.get("adminName").toString();
		}
		total = logMapper.count(adminName);
		resultMap.put("total", total);
		if (total % Data.NUM == 0)
		{
			totalPage = total / Data.NUM;
		} else
		{
			totalPage = total / Data.NUM + 1;
		}
		if (totalPage == 0)
		{
			totalPage = 1;
		}
		resultMap.put("totalPage", totalPage);
		Integer currentPage = (Integer) condition.get("currentPage");
		if (currentPage > totalPage)
		{
			currentPage = totalPage;
		}
		int max = currentPage * Data.NUM + 1;
		int min = (currentPage - 1) * Data.NUM;
		condition.put("max", max);
		condition.put("min", min);
		resultMap.put("currentPage", currentPage);
		resultMap.put("logs", logMapper.getLogs(condition));
		return resultMap;
	}

	@Override
	public void delLog(Integer logId)
	{
		logMapper.delLog(logId);
	}

	@Override
	public void delLogs(Integer[] logId)
	{
		for (int i = 0; i < logId.length; i++)
		{
			logMapper.delLog(logId[i]);
		}

	}

}
