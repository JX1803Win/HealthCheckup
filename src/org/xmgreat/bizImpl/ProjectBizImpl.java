package org.xmgreat.bizImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.xmgreat.bean.DetailBean;
import org.xmgreat.bean.ParameterBean;
import org.xmgreat.bean.ProjectBean;
import org.xmgreat.biz.ProjectBiz;
import org.xmgreat.mapper.DetailMapper;
import org.xmgreat.mapper.OfficeMapper;
import org.xmgreat.mapper.ParamMapper;
import org.xmgreat.mapper.ProjectlMapper;
import org.xmgreat.util.Data;

@Service
public class ProjectBizImpl implements ProjectBiz
{
	@Resource
	private ProjectlMapper projectlMapper;
	@Resource
	private DetailMapper detailMapper;
	@Resource
	private ParamMapper paramMapper;
	@Resource
	private OfficeMapper officeMapper;

	public Integer totalPage;
	public Integer total;

	@Override
	public Map<String, Object> search(Map<String, Object> condition)
	{
		Map<String, Object> resultMap = new HashMap<String, Object>();
		String itemName = null;
		if (condition.get("itemName") != null)
		{
			itemName = condition.get("itemName").toString();
		}
		total = projectlMapper.count(itemName);
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
		resultMap.put("projects", projectlMapper.getProjects(condition));
		return resultMap;
	}

	@Override
	public ProjectBean getProject(Integer projectId)
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
	public Map<String, Object> skipAddProject()
	{
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("parameters", paramMapper.getParameters(9));
		resultMap.put("offices", officeMapper.selectAll());
		resultMap.put("details", detailMapper.selectAll());
		return resultMap;
	}

	@Override
	public void addProject(ProjectBean projectBean, Integer[] subentryId)
	{
		projectlMapper.addProject(projectBean);
		ProjectBean project = projectlMapper.selectProject(projectBean.getItemName());
		for (int i = 0; i < subentryId.length; i++)
		{
			projectlMapper.addRelation(project.getProjectId(), subentryId[i]);
		}
	}

	@Override
	public void delProject(Integer projectId)
	{
		projectlMapper.delRelation(projectId);
		projectlMapper.delProject(projectId);

	}

	@Override
	public Map<String, Object> skipUpdateProject(Integer projectId)
	{
		Map<String, Object> resultMap = new HashMap<String, Object>();
		ProjectBean projectBean = projectlMapper.getProject(projectId);
		List<DetailBean> detail = projectBean.getDetails();
		List<DetailBean> details = detailMapper.selectAll();
		List<DetailBean> detail1 = new ArrayList<DetailBean>();
		for (int i = 0; i < details.size(); i++)
		{
			int k = 0;
			for (int j = 0; j < detail.size(); j++)
			{
				if (details.get(i).getDetailName().equals(detail.get(j).getDetailName()))
				{
					k = 1;
				}
			}
			if (k == 0)
			{
				detail1.add(details.get(i));
			}
		}
		resultMap.put("project", projectBean);
		resultMap.put("parameters", paramMapper.getParameters(9));
		resultMap.put("offices", officeMapper.selectAll());
		resultMap.put("details", detail1);
		return resultMap;
	}

	@Override
	public void updateProject(ProjectBean projectBean, Integer[] subentryId)
	{
		projectlMapper.updateProject(projectBean);
		projectlMapper.delRelation(projectBean.getProjectId());
		if (subentryId != null)
		{
			for (int i = 0; i < subentryId.length; i++)
			{
				projectlMapper.addRelation(projectBean.getProjectId(), subentryId[i]);
			}
		}
	}

	@Override
	public ProjectBean checkProject1(String itemName)
	{
		return projectlMapper.selectProject(itemName);
	}

}
