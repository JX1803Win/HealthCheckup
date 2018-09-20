package org.xmgreat.bean;

import org.springframework.stereotype.Component;

@Component
public class Province
{
	private int provinceId; // 省份id
	private String provinceName; // 省份名称

	public Province()
	{
		super();
	}

	public Province(int provinceId, String provinceName)
	{
		super();
		this.provinceId = provinceId;
		this.provinceName = provinceName;
	}

	public int getProvinceId()
	{
		return provinceId;
	}

	public void setProvinceId(int provinceId)
	{
		this.provinceId = provinceId;
	}

	public String getProvinceName()
	{
		return provinceName;
	}

	public void setProvinceName(String provinceName)
	{
		this.provinceName = provinceName;
	}

}
