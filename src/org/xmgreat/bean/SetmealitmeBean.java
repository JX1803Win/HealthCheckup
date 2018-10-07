package org.xmgreat.bean;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class SetmealitmeBean
{// 套餐项目信息关系表
	private Integer projectId;// 项目ID
	private Integer setmealId;// 套餐ID
	private List<ProjectBean> pbList;// 项目表list
	private List<SetmealBean> sbList;// 套餐表list

	public SetmealitmeBean()
	{
		// TODO Auto-generated constructor stub
	}

	public SetmealitmeBean(Integer projectId, Integer setmealId, List<ProjectBean> pbList, List<SetmealBean> sbList)
	{
		super();
		this.projectId = projectId;
		this.setmealId = setmealId;
		this.pbList = pbList;
		this.sbList = sbList;
	}

	public Integer getProjectId()
	{
		return projectId;
	}

	public void setProjectId(Integer projectId)
	{
		this.projectId = projectId;
	}

	public Integer getSetmealId()
	{
		return setmealId;
	}

	public void setSetmealId(Integer setmealId)
	{
		this.setmealId = setmealId;
	}

	public List<ProjectBean> getPbList()
	{
		return pbList;
	}

	public void setPbList(List<ProjectBean> pbList)
	{
		this.pbList = pbList;
	}

	public List<SetmealBean> getSbList()
	{
		return sbList;
	}

	public void setSbList(List<SetmealBean> sbList)
	{
		this.sbList = sbList;
	}

}
