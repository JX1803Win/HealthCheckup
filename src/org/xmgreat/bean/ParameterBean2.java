package org.xmgreat.bean;

import org.springframework.stereotype.Component;

@Component
public class ParameterBean2
{
	
	private String parameterValues; // 参数值
	private Integer parameterType; // 参数类型
	private String typeName; // 类型名称
	private String paramId2; // 参数id
	private String paramName2; // 参数名称
	public ParameterBean2()
	{
		super();
	}

	

	public String getParamId2() {
		return paramId2;
	}

	public void setParamId2(String paramId2) {
		this.paramId2 = paramId2;
	}


	public String getParamName2() {
		return paramName2;
	}

	public void setParamName2(String paramName2) {
		this.paramName2 = paramName2;
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
