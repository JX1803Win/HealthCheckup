package org.xmgreat.bizImpl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.xmgreat.bean.ParameterBean;
import org.xmgreat.bean.ProjectBean;
import org.xmgreat.biz.SummaryBiz;
import org.xmgreat.mapper.ParamMapper;
import org.xmgreat.mapper.ProjectlMapper;

@Service
public class SummaryBizImpl implements SummaryBiz
{

	@Resource
	private ProjectlMapper projectlMapper;
	@Resource
	private ParamMapper paramMapper;

	@Override
	public ProjectBean skipExamination(Integer projectId)
	{
		ProjectBean project = projectlMapper.getProject(projectId);
		for (int i = 0; i < project.getDetails().size(); i++)
		{
			ParameterBean parameter = paramMapper.getParameter(project.getDetails().get(i).getParameterId());
			project.getDetails().get(i).setParameterBean(parameter);
		}
		return project;

	}

}
