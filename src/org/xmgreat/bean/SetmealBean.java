package org.xmgreat.bean;

import java.util.List;

import org.springframework.stereotype.Component;
@Component
public class SetmealBean
{
	private Integer setmealId; // 套餐id
	private String setmealName; // 套餐名
	private List<ProjectBean> items; // 项目列表
    private SetmealitmeBean setmealitmeBean;
	public SetmealBean()
	{
		super();
	}

	public SetmealBean(Integer setmealId, String setmealName, List<ProjectBean> items)
	{
		super();
		this.setmealId = setmealId;
		this.setmealName = setmealName;
		this.items = items;
	}

	public SetmealitmeBean getSetmealitmeBean() {
		return setmealitmeBean;
	}

	public void setSetmealitmeBean(SetmealitmeBean setmealitmeBean) {
		this.setmealitmeBean = setmealitmeBean;
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
