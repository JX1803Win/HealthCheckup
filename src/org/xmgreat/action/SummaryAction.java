package org.xmgreat.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.xmgreat.bean.ProjectBean;
import org.xmgreat.biz.SummaryBiz;

public class SummaryAction
{
	@Resource
	private SummaryBiz summaryBiz;

	@RequestMapping(value = "/skipExamination")
	public String skipExamination(HttpServletRequest request, Integer projectId)
	{
		String str = null;

		ProjectBean project = summaryBiz.skipExamination(projectId);
		if (project.getParameterId() == 26)
		{
			str = "backstage/examination1";
		} else if (project.getParameterId() == 27)
		{
			str = "backstage/examination2";
		} else
		{
			str = "backstage/examination3";
		}
		request.setAttribute("project", project);

		return str;
	}

}
