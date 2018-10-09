package org.xmgreat.action;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.xmgreat.bean.ManagerBean;
import org.xmgreat.bean.ProjectBean;
import org.xmgreat.bean.ProjectResultBean;
import org.xmgreat.biz.SummaryBiz;

/**
 * @author 周鸿谊
 * @date 2018年9月28日
 * @description 医师小结
 */

@Controller
@RequestMapping("/backstage")
public class SummaryAction
{
	@Resource
	private SummaryBiz summaryBiz;
	@Resource
	private DoctorAction doctorAction;

	private Map<String, Object> resultMap; // 结果map

	@RequestMapping(value = "/skipExamination")
	public String skipExamination(HttpServletRequest request, Integer projectId, Integer proresId)
	{

		ProjectBean project = summaryBiz.skipExamination(projectId);
		request.setAttribute("proresId", proresId);
		request.setAttribute("project", project);
		return "backstage/examination";
	}

	@RequestMapping(value = "/querySummary")
	public String querySummary(HttpServletRequest request, Integer parameterId, Integer currentPage)
	{
		Map<String, Object> condition = new HashMap<String, Object>(); // 条件map
		if (currentPage == null)
		{
			currentPage = 1;
		}
		ManagerBean managerBean = (ManagerBean) request.getSession().getAttribute("admin");
		condition.put("officeId", managerBean.getOfficeId());
		condition.put("currentPage", currentPage);
		if (null != parameterId && parameterId != 0)
		{
			condition.put("parameterId", parameterId);
		}
		resultMap = summaryBiz.querySummary(condition);
		request.setAttribute("parameterId", parameterId);
		request.setAttribute("resultMap", resultMap);
		return "backstage/userSummary";
	}

	@RequestMapping(value = "/particular")
	public String particular(HttpServletRequest request, Integer proresId, Integer parameterId, Integer currentPage)
	{
		ProjectResultBean projectResultBean = summaryBiz.skipSummary(proresId);
		request.setAttribute("projectResult", projectResultBean);
		request.setAttribute("parameterId", parameterId);
		request.setAttribute("currentPage", currentPage);
		return "backstage/particular";
	}

	@RequestMapping(value = "/skipSummary")
	public String skipSummary(HttpServletRequest request, Integer proresId)
	{
		ProjectResultBean projectResultBean = summaryBiz.skipSummary(proresId);
		request.setAttribute("projectResult", projectResultBean);
		return "backstage/summary";
	}

	@RequestMapping(value = "/generalSummary")
	public String generalSummary(HttpServletRequest request, Integer proresId, Integer[] subentryId, String[] result,
			String projectResult, Integer parameterId)
	{
		summaryBiz.generalSummary(proresId, subentryId, result, projectResult, parameterId);
		return querySummary(request, null, null);
	}

	@RequestMapping(value = "/projectSummary")
	public String projectSummary(HttpServletRequest request, Integer proresId, Integer[] subentryId, String[] result,
			String projectResult, Integer parameterId)
	{
		summaryBiz.projectSummary(proresId, subentryId, result, projectResult, parameterId);
		return querySummary(request, null, null);
	}

	@RequestMapping(value = "/imageSummary")
	public String imageSummary(HttpServletRequest request, Integer proresId, Integer[] subentryId, String projectResult,
			Integer parameterId) throws Exception
	{
		summaryBiz.imageSummary(proresId, subentryId, request, projectResult, parameterId);
		return querySummary(request, null, null);
	}
}
