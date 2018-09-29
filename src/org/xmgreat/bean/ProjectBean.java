package org.xmgreat.bean;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class ProjectBean
{
	private Integer projectId; // 项目id
	private String itemName; // 项目名称
	private Double charge; // 费用
	private Integer parameterId; // 小结类型
	private Integer officeId; // 科室id

	// 关联属性
	private ParameterBean parameterBean; // 参数实体
	private OfficeBean officeBean; // 科室实体
	private List<DetailBean> details; // 细项实体列表
	private ManaDepaRelaBean manaDepaRelaBean;//管理员科室关系表
	public ProjectBean()
	{
		super();
	}

	public ProjectBean(Integer projectId, String itemName, Integer officeId, OfficeBean officeBean, Integer parameterId,
			Double charge, ParameterBean parameterBean, List<DetailBean> details)
	{
		super();
		this.projectId = projectId;
		this.itemName = itemName;
		this.officeId = officeId;
		this.officeBean = officeBean;
		this.parameterId = parameterId;
		this.charge = charge;
		this.parameterBean = parameterBean;
		this.details = details;
	}

	public ManaDepaRelaBean getManaDepaRelaBean() {
		return manaDepaRelaBean;
	}

	public void setManaDepaRelaBean(ManaDepaRelaBean manaDepaRelaBean) {
		this.manaDepaRelaBean = manaDepaRelaBean;
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

	public OfficeBean getOfficeBean()
	{
		return officeBean;
	}

	public void setOfficeBean(OfficeBean officeBean)
	{
		this.officeBean = officeBean;
	}

	public Integer getParameterId()
	{
		return parameterId;
	}

	public void setParameterId(Integer parameterId)
	{
		this.parameterId = parameterId;
	}

	public Double getCharge()
	{
		return charge;
	}

	public void setCharge(Double charge)
	{
		this.charge = charge;
	}

	public ParameterBean getParameterBean()
	{
		return parameterBean;
	}

	public void setParameterBean(ParameterBean parameterBean)
	{
		this.parameterBean = parameterBean;
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
