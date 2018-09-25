package org.xmgreat.bizImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.xmgreat.bean.ProjectBean;
import org.xmgreat.biz.ProjectBiz;
import org.xmgreat.mapper.DetailMapper;
import org.xmgreat.mapper.ProjectlMapper;
import org.xmgreat.util.Data;

@Service
public class ProjectBizImpl implements ProjectBiz
{
	@Resource
	private ProjectlMapper projectlMapper;
	@Resource
	private DetailMapper detailMapper;

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
		List<ProjectBean> p = projectlMapper.getProjects(condition);
		ProjectBean p1 = p.get(0);
		resultMap.put("projects", projectlMapper.getProjects(condition));
		return resultMap;
	}

	@Override
	public ProjectBean getProject(Integer projectId)
	{
		return projectlMapper.getProject(projectId);
	}

	@Override
	public Map<String, Object> skipAddProject()
	{
		Map<String, Object> resultMap = new HashMap<String, Object>();

		resultMap.put("details", detailMapper.selectAll());
		return resultMap;
	}

	@Override
	public void addProject(ProjectBean projectBean, Integer[] subentryId)
	{
		
		
	}

}
