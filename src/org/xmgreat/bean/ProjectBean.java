package org.xmgreat.bean;

import java.util.List;

import org.springframework.stereotype.Component;
@Component
public class ProjectBean
{
	private Integer projectId; // 项目id
	private String itemName; // 项目名称
	private Integer officeId; // 科室id
	private OfficeBean office; // 科室实体
	private List<DetailBean> details; // 细项实体列表

	public ProjectBean()
	{
		super();
	}

	public ProjectBean(Integer projectId, String itemName, Integer officeId, OfficeBean office, List<DetailBean> details)
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

	public OfficeBean getOffice()
	{
		return office;
	}

	public void setOffice(OfficeBean office)
	{
		this.office = office;
	}

	public List<DetailBean> getDetails()
	{
		return details;
	}

	public void setDetails(List<DetailBean> details)
	{
		this.details = details;
	}

}
