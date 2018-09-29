package org.xmgreat.bean;

import org.springframework.stereotype.Component;

@Component
public class CityBean
{
	private Integer cityId; // 城市id
	private Integer provinceId; // 省份id
	private String cityName; // 城市名
	private Province province; // 省份实体

	public CityBean()
	{
		super();
	}

	public CityBean(Integer cityId, Integer provinceId, String cityName, Province province)
	{
		super();
		this.cityId = cityId;
		this.provinceId = provinceId;
		this.cityName = cityName;
		this.province = province;
	}

	public Integer getCityId()
	{
		return cityId;
	}

	public void setCityId(Integer cityId)
	{
		this.cityId = cityId;
	}

	public Integer getProvinceId()
	{
		return provinceId;
	}

	public void setProvinceId(Integer provinceId)
	{
		this.provinceId = provinceId;
	}

	public String getCityName()
	{
		return cityName;
	}

	public void setCityName(String cityName)
	{
		this.cityName = cityName;
	}

	public Province getProvince()
	{
		return province;
	}

	public void setProvince(Province province)
	{
		this.province = province;
	}

}
