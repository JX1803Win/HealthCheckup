package org.xmgreat.bizImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.xmgreat.bean.LogBean;
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

	@Override
	public Map<String, Object> exportExcel()
	{
		Map<String, Object> dataMap = new HashMap<String, Object>();
		List<String> titleList = new ArrayList<String>();
		titleList.add("管理员");
		titleList.add("执行模块");
		titleList.add("执行方法");
		titleList.add("响应时间");
		titleList.add("IP地址");
		titleList.add("执行时间");
		titleList.add("执行描述");
		dataMap.put("titles", titleList);
		// 查询数据，将放入excel中
		List<LogBean> listAllScore = logMapper.selectAll();
		List<Map<String, Object>> logData = new ArrayList<Map<String, Object>>();
		for (int i = 0; i < listAllScore.size(); i++)
		{
			Map<String, Object> tempMap = new HashMap<String, Object>();
			tempMap.put("var1", listAllScore.get(i).getManagerBean().getMangerName());
			tempMap.put("var2", listAllScore.get(i).getModule());
			tempMap.put("var3", listAllScore.get(i).getMethod());
			tempMap.put("var4", listAllScore.get(i).getRsponseDate());
			tempMap.put("var5", listAllScore.get(i).getIp());
			tempMap.put("var6", listAllScore.get(i).getExecutionDate());
			tempMap.put("var7", listAllScore.get(i).getCommite());
			logData.add(tempMap);
		}
		dataMap.put("objData", logData);
		return dataMap;
	}

}
