package org.xmgreat.bizImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.xmgreat.bean.ParameterBean;
import org.xmgreat.bean.ProjectBean;
import org.xmgreat.bean.SetmealBean;
import org.xmgreat.biz.SetmealBiz;
import org.xmgreat.mapper.DetailMapper;
import org.xmgreat.mapper.OfficeMapper;
import org.xmgreat.mapper.ParamMapper;
import org.xmgreat.mapper.ProjectlMapper;
import org.xmgreat.mapper.SetmealMapper;
import org.xmgreat.util.Data;

@Service
public class SetmealBizImpl implements SetmealBiz
{
	@Resource
	private SetmealMapper setmealMapper;
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
		String setmealName = null;
		if (condition.get("setmealName") != null)
		{
			setmealName = condition.get("setmealName").toString();
		}
		total = setmealMapper.count(setmealName);
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
		resultMap.put("setmeals", setmealMapper.getSetmeals(condition));
		return resultMap;
	}

	@Override
	public SetmealBean getSetmeal(Integer setmealId)
	{
		SetmealBean setmealBean = setmealMapper.getSetmeal(setmealId);
		List<ProjectBean> projects = new ArrayList<ProjectBean>();
		for (int i = 0; i < setmealBean.getItems().size(); i++)
		{
			ProjectBean project = projectlMapper.getProject(setmealBean.getItems().get(i).getProjectId());
			for (int j = 0; j < project.getDetails().size(); j++)
			{
				ParameterBean parameter = paramMapper.getParameter(project.getDetails().get(j).getParameterId());
				project.getDetails().get(j).setParameterBean(parameter);
			}
			projects.add(project);
		}
		setmealBean.setItems(projects);
		return setmealBean;
	}

	@Override
	public List<ProjectBean> skipAddSetmeal()
	{

		return projectlMapper.selectAll();
	}

	@Override
	public void addSetmeal(SetmealBean setmealBean, Integer[] setmealId)
	{
		setmealMapper.addSetmeal(setmealBean);
		SetmealBean setmeal = setmealMapper.selectSetmeal(setmealBean.getSetmealName());
		for (int i = 0; i < setmealId.length; i++)
		{
			setmealMapper.addRelation(setmeal.getSetmealId(), setmealId[i]);
		}
	}

	@Override
	public void delSetmeal(Integer setmealId)
	{
		setmealMapper.delRelation(setmealId);
		setmealMapper.delSetmeal(setmealId);
	}

	@Override
	public Map<String, Object> skipUpdateSetmeal(Integer setmealId)
	{
		Map<String, Object> resultMap = new HashMap<String, Object>();
		SetmealBean setmealBean = setmealMapper.getSetmeal(setmealId);
		List<ProjectBean> project = setmealBean.getItems();
		List<ProjectBean> projects = projectlMapper.selectAll();
		List<ProjectBean> project1 = new ArrayList<ProjectBean>();
		for (int i = 0; i < projects.size(); i++)
		{
			int k = 0;
			for (int j = 0; j < project.size(); j++)
			{
				if (projects.get(i).getItemName().equals(project.get(j).getItemName()))
				{
					k = 1;
				}
			}
			if (k == 0)
			{
				project1.add(projects.get(i));
			}
		}
		resultMap.put("setmeal", setmealBean);
		resultMap.put("projects", project1);
		return resultMap;
	}

	@Override
	public void updateSetmeal(SetmealBean setmealBean, Integer[] projectId)
	{
		setmealMapper.updateSetmeal(setmealBean);
		setmealMapper.delRelation(setmealBean.getSetmealId());
		if (projectId != null)
		{
			for (int i = 0; i < projectId.length; i++)
			{
				setmealMapper.addRelation(setmealBean.getSetmealId(), projectId[i]);
			}
		}
	}

	@Override
	public SetmealBean checkSetmealName(String setmealName)
	{
		return setmealMapper.selectSetmeal(setmealName);
	}

}
