package org.xmgreat.bean;

public class DetailBean
{
	private Integer detailId; // 细项id
	private String detailName; // 细项名
	private Double price; // 价格
	private Integer parameterId; // 单位
	private Double upperLimit; // 上限值
	private Double lowerLimit; // 下限值
	private ParameterBean parameterBean; // 参数实体

	public DetailBean()
	{
		super();
	}

	public DetailBean(Integer detailId, String detailName, Double price, Integer parameterId, Double upperLimit,
			Double lowerLimit, ParameterBean parameterBean)
	{
		super();
		this.detailId = detailId;
		this.detailName = detailName;
		this.price = price;
		this.parameterId = parameterId;
		this.upperLimit = upperLimit;
		this.lowerLimit = lowerLimit;
		this.parameterBean = parameterBean;
	}

	public Integer getDetailId()
	{
		return detailId;
	}

	public void setDetailId(Integer detailId)
	{
		this.detailId = detailId;
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
