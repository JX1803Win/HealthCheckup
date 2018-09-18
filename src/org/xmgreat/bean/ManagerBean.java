package org.xmgreat.bean;

import org.springframework.stereotype.Repository;

@Repository
public class ManagerBean
{// 管理员信息表
	private Integer adminId;
	private String mangerName;
	private String sex;
	private Integer age;
	private String birthDate;
	private Integer cityId;
	private String address;// 地址
	private Long phoneNum;
	private String password;
	private Integer ruleId;
	private Integer officeId;// 科室id
	private Integer paramterId;// 参数

	public ManagerBean()
	{
		// TODO Auto-generated constructor stub
	}

	public ManagerBean(Integer adminId, String mangerName, String sex, Integer age, String birthDate, Integer cityId,
			String address, Long phoneNum, String password, Integer ruleId, Integer officeId, Integer paramterId)
	{
		super();
		this.adminId = adminId;
		this.mangerName = mangerName;
		this.sex = sex;
		this.age = age;
		this.birthDate = birthDate;
		this.cityId = cityId;
		this.address = address;
		this.phoneNum = phoneNum;
		this.password = password;
		this.ruleId = ruleId;
		this.officeId = officeId;
		this.paramterId = paramterId;
	}

	public Integer getAdminId()
	{
		return adminId;
	}

	public void setAdminId(Integer adminId)
	{
		this.adminId = adminId;
	}

	public String getMangerName()
	{
		return mangerName;
	}

	public void setMangerName(String mangerName)
	{
		this.mangerName = mangerName;
	}

	public String getSex()
	{
		return sex;
	}

	public void setSex(String sex)
	{
		this.sex = sex;
	}

	public Integer getAge()
	{
		return age;
	}

	public void setAge(Integer age)
	{
		this.age = age;
	}

	public String getBirthDate()
	{
		return birthDate;
	}

	public void setBirthDate(String birthDate)
	{
		this.birthDate = birthDate;
	}

	public Integer getCityId()
	{
		return cityId;
	}

	public void setCityId(Integer cityId)
	{
		this.cityId = cityId;
	}

	public String getAddress()
	{
		return address;
	}

	public void setAddress(String address)
	{
		this.address = address;
	}

	public Long getPhoneNum()
	{
		return phoneNum;
	}

	public void setPhoneNum(Long phoneNum)
	{
		this.phoneNum = phoneNum;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public Integer getRuleId()
	{
		return ruleId;
	}

	public void setRuleId(Integer ruleId)
	{
		this.ruleId = ruleId;
	}

	public Integer getOfficeId()
	{
		return officeId;
	}

	public void setOfficeId(Integer officeId)
	{
		this.officeId = officeId;
	}

	public Integer getParamterId()
	{
		return paramterId;
	}

	public void setParamterId(Integer paramterId)
	{
		this.paramterId = paramterId;
	}

}
