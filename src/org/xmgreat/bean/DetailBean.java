package org.xmgreat.bean;

import org.springframework.stereotype.Component;

@Component
public class DetailBean
{
	private Integer subentryId; // 细项id
	private String detailName; // 细项名
	private Double price; // 价格
	private Integer parameterId; // 单位
	private Double upperLimit; // 上限值
	private Double lowerLimit; // 下限值
	private ParameterBean parameterBean; // 参数实体
	private String initValue; // 默认值

	public DetailBean()
	{
		super();
	}

	public DetailBean(Integer subentryId, String detailName, Double price, Integer parameterId, Double upperLimit,
			Double lowerLimit, ParameterBean parameterBean, String initValue)
	{
		super();
		this.subentryId = subentryId;
		this.detailName = detailName;
		this.price = price;
		this.parameterId = parameterId;
		this.upperLimit = upperLimit;
		this.lowerLimit = lowerLimit;
		this.parameterBean = parameterBean;
		this.initValue = initValue;
	}

	public Integer getSubentryId()
	{
		return subentryId;
	}

	public void setSubentryId(Integer subentryId)
	{
		this.subentryId = subentryId;
	}

	public String getInitValue()
	{
		return initValue;
	}

	public void setInitValue(String initValue)
	{
		this.initValue = initValue;
	}

	public String getDetailName()
	{
		return detailName;
	}

	public void setDetailName(String detailName)
	{
		this.detailName = detailName;
	}

	public Double getPrice()
	{
		return price;
	}

	public void setPrice(Double price)
	{
		this.price = price;
	}

	public Integer getParameterId()
	{
		return parameterId;
	}

	public void setParameterId(Integer parameterId)
	{
		this.parameterId = parameterId;
	}

	public Double getUpperLimit()
	{
		return upperLimit;
	}

	public void setUpperLimit(Double upperLimit)
	{
		this.upperLimit = upperLimit;
	}

	public Double getLowerLimit()
	{
		return lowerLimit;
	}

	public void setLowerLimit(Double lowerLimit)
	{
		this.lowerLimit = lowerLimit;
	}

	public ParameterBean getParameterBean()
	{
		return parameterBean;
	}

	public void setParameterBean(ParameterBean parameterBean)
	{
		this.parameterBean = parameterBean;
	}

}
