package org.xmgreat.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.xmgreat.bean.ProjectBean;
import org.xmgreat.bean.ProjectResultBean;
import org.xmgreat.biz.SummaryBiz;
import org.springframework.web.servlet.ModelAndView;

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

	@RequestMapping(value = "/skipExamination")
	public String skipExamination(HttpServletRequest request, Integer projectId, Integer proresId)
	{

		ProjectBean project = summaryBiz.skipExamination(projectId);
		request.setAttribute("proresId", proresId);
		request.setAttribute("project", project);
		return "backstage/examination";
	}

	@RequestMapping(value = "/generalSummary")
	public ModelAndView generalSummary(HttpServletRequest request, Integer proresId, Integer[] subentryId,
			String[] result) throws Exception
	{
		summaryBiz.generalSummary(proresId, subentryId, result);
		return doctorAction.selectAllRole(request, null, null);
	}

	@RequestMapping(value = "/skipSummary")
	public String skipSummary(HttpServletRequest request, Integer projectId, Integer proresId)
	{

		ProjectResultBean projectResultBean = summaryBiz.skipSummary(proresId);
		request.setAttribute("projectResult", projectResultBean);
		return "backstage/summary";
	}
}