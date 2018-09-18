package org.xmgreat.bean;

import java.util.List;

public class SetmealBena
{
	private Integer setmealId; // 套餐id
	private String setmealName; // 套餐名
	private List<ItemBean> items; // 项目列表

	public SetmealBena()
	{
		super();
	}

	public SetmealBena(Integer setmealId, String setmealName, List<ItemBean> items)
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

	public List<ItemBean> getItems()
	{
		return items;
	}

	public void setItems(List<ItemBean> items)
	{
		this.items = items;
	}

}
