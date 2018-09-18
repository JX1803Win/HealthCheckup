package org.xmgreat.bean;

import java.util.List;

public class ProjectBean
{
	private Integer projectId; // 项目id
	private String itemName; // 项目名称
	private Integer officeId; // 科室id
	private Office office; // 科室实体
	private List<Detail> details; // 细项实体列表

	public ProjectBean()
	{
		super();
	}

	public ProjectBean(Integer projectId, String itemName, Integer officeId, Office office, List<Detail> details)
	{
		super();
		this.projectId = projectId;
		this.itemName = itemName;
		this.officeId = officeId;
		this.office = office;
		this.details = details;
	}

	public Integer getProjectId()
	{
		return projectId;
	}

	public void setProjectId(Integer projectId)
	{
		this.projectId = projectId;
	}

	public String getItemName()
	{
		return itemName;
	}

	public void setItemName(String itemName)
	{
		this.itemName = itemName;
	}

	public Integer getOfficeId()
	{
		return officeId;
	}

	public void setOfficeId(Integer officeId)
	{
		this.officeId = officeId;
	}

	public Office getOffice()
	{
		return office;
	}

	public void setOffice(Office office)
	{
		this.office = office;
	}

	public List<Detail> getDetails()
	{
		return details;
	}

	public void setDetails(List<Detail> details)
	{
		this.details = details;
	}

}
