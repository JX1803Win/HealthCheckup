package org.xmgreat.bean;

import java.util.List;

public class ItemBean
{
	private Integer itemId; // 项目id
	private String itemName; // 项目名称
	private Integer officeId; // 科室id
	private Office office; // 科室实体
	private List<Detail> details; // 细项实体列表

	public ItemBean()
	{
		super();
	}

	public ItemBean(Integer itemId, String itemName, Integer officeId, Office office, List<Detail> details)
	{
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		this.officeId = officeId;
		this.office = office;
		this.details = details;
	}

	public Integer getItemId()
	{
		return itemId;
	}

	public void setItemId(Integer itemId)
	{
		this.itemId = itemId;
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
