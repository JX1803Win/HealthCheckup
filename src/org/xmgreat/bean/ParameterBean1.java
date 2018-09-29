package org.xmgreat.bean;

import org.springframework.stereotype.Component;

@Component
public class ParameterBean1
{
	
	private String parameterValues; // 参数值
	private Integer parameterType; // 参数类型
	private String typeName; // 类型名称
	private String paramId1; // 参数id
	private String paramName1; // 参数名称
	public ParameterBean1()
	{
		super();
	}

	public String getParamId1() {
		return paramId1;
	}

	public void setParamId1(String paramId1) {
		this.paramId1 = paramId1;
	}


	public String getParamName1() {
		return paramName1;
	}

	public void setParamName1(String paramName1) {
		this.paramName1 = paramName1;
	}


	public String getParameterValues()
	{
		return parameterValues;
	}

	public void setParameterValues(String parameterValues)
	{
		this.parameterValues = parameterValues;
	}

	public Integer getParameterType()
	{
		return parameterType;
	}

	public void setParameterType(Integer parameterType)
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
