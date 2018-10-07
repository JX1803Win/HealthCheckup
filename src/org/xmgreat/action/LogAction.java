package org.xmgreat.action;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.xmgreat.biz.LogBiz;

/**
 * @author 周鸿谊
 * @date 2018年9月20日
 * @description 日志管理
 */

@Controller
@RequestMapping("/backstage")
public class LogAction
{

	@Resource
	private LogBiz logBiz;
	private Map<String, Object> resultMap; // 结果map

	@RequestMapping(value = "/queryLog")
	public String queryLog(HttpServletRequest request, String adminName, Integer currentPage)
	{
		Map<String, Object> condition = new HashMap<String, Object>(); // 条件map
		if (currentPage == null)
		{
			currentPage = 1;
		}
		condition.put("currentPage", currentPage);
		if (null != adminName && !"".equals(adminName))
		{
			condition.put("adminName", "%" + adminName + "%");
		}
		resultMap = logBiz.search(condition);
		request.setAttribute("adminName", adminName);
		request.setAttribute("resultMap", resultMap);
		return "backstage/log";
	}

	@RequestMapping(value = "/delLog")
	public String delLog(HttpServletRequest request, String adminName, Integer currentPage, Integer logId)
	{
		logBiz.delLog(logId);
		return queryLog(request, adminName, currentPage);
	}

	@RequestMapping(value = "/delLogs")
	public String delLogs(HttpServletRequest request, String adminName, Integer currentPage, Integer[] logId)
	{
		logBiz.delLogs(logId);
		return queryLog(request, adminName, currentPage);
	}
}
