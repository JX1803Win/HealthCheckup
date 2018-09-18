package org.xmgreat.bean;

public class ParameterBean
{
	private int parameterId; // 参数id
	private String parameterName; // 参数名称
	private String parameterValues; // 参数值
	private int parameterType; // 参数类型
	private String typeName; // 类型名称

	public ParameterBean()
	{
		super();
	}

	public ParameterBean(int parameterId, String parameterName, String parameterValues, int parameterType,
			String typeName)
	{
		super();
		this.parameterId = parameterId;
		this.parameterName = parameterName;
		this.parameterValues = parameterValues;
		this.parameterType = parameterType;
		this.typeName = typeName;
	}

	public int getParameterId()
	{
		return parameterId;
	}

	public void setParameterId(int parameterId)
	{
		this.parameterId = parameterId;
	}

	public String getParameterName()
	{
		return parameterName;
	}

	public void setParameterName(String parameterName)
	{
		this.parameterName = parameterName;
	}

	public String getParameterValues()
	{
		return parameterValues;
	}

	public void setParameterValues(String parameterValues)
	{
		this.parameterValues = parameterValues;
	}

	public int getParameterType()
	{
		return parameterType;
	}

	public void setParameterType(int parameterType)
	{
		this.parameterType = parameterType;
	}

	public String getTypeName()
	{
		return typeName;
	}

	public void setTypeName(String typeName)
	{
		this.typeName = typeName;
	}

}
