package org.xmgreat.bizImpl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.xmgreat.bean.ParameterBean;
import org.xmgreat.bean.ProjectBean;
import org.xmgreat.bean.ProjectResultBean;
import org.xmgreat.bean.SubentryBean;
import org.xmgreat.biz.SummaryBiz;
import org.xmgreat.mapper.ParamMapper;
import org.xmgreat.mapper.ProjectResultMapper;
import org.xmgreat.mapper.ProjectlMapper;
import org.xmgreat.mapper.SubentryMapper;

@Service
public class SummaryBizImpl implements SummaryBiz
{

	@Resource
	private ProjectlMapper projectlMapper;
	@Resource
	private ParamMapper paramMapper;
	@Resource
	private SubentryMapper subentryMapper;
	@Resource
	private ProjectResultMapper projectResultMapper;
	@Resource
	private ProjectResultBean projectResultBean;

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

	@Override
	public void generalSummary(Integer proresId, Integer[] subentryId, String[] result)
	{
		for (int i = 0; i < subentryId.length; i++)
		{
			subentryMapper.addSubentry(new SubentryBean(null, subentryId[i], result[i], null, proresId, null, null));
		}
		projectResultBean = projectResultMapper.getProjectResult(proresId);
		projectResultBean.setParameterId(12);
		projectResultMapper.updateProjectResul(projectResultBean);

	}

	@Override
	public void generalSummary(Integer proresId, Integer[] subentryId, String[] result, String projectResult)
	{
		for (int i = 0; i < subentryId.length; i++)
		{
			subentryMapper.addSubentry(new SubentryBean(null, subentryId[i], result[i], null, proresId, null, null));
		}

		projectResultBean = projectResultMapper.getProjectResult(proresId);
		projectResultBean.setParameterId(13);
		projectResultBean.setProjectResult(projectResult);
		projectResultMapper.updateProjectResul(projectResultBean);

	}
	
	@Override
	public ProjectResultBean skipSummary(Integer proresId)
	{
		// TODO Auto-generated method stub
		return projectResultMapper.getProjectResult(proresId);
	}

}
