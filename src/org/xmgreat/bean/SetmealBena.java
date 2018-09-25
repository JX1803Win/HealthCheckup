package org.xmgreat.bean;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class SetmealBena
{
	private Integer setmealId; // 套餐id
	private String setmealName; // 套餐名
	private List<ProjectBean> items; // 项目列表

	public SetmealBena()
	{
		super();
	}

	public SetmealBena(Integer setmealId, String setmealName, List<ProjectBean> items)
	{
		super();
		this.setmealId = setmealId;
		this.setmealName = setmealName;
		this.items = items;
	}

	public Integer getSetmealId()
	{
		return setmealId;
	}

	public void setSetmealId(Integer setmealId)
	{
		this.setmealId = setmealId;
	}

	public String getSetmealName()
	{
		return setmealName;
	}

	public void setSetmealName(String setmealName)
	{
		this.setmealName = setmealName;
	}

	public List<ProjectBean> getItems()
	{
		return items;
	}

	public void setItems(List<ProjectBean> items)
	{
		this.items = items;
	}

}
