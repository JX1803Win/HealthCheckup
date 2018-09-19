package org.xmgreat.bean;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
public class ManagerBean
{// 管理员信息表
	private Integer adminId; // 管理员id
	private String mangerName; // 管理员名称
	private String sex; // 性别
	private Integer age; // 年龄
	private String birthDate; // 生日
	private String address;// 地址
	private Long phoneNum; // 电话号码
	private String password; // 密码
	private Integer roleId; // 角色id
	private Integer officeId;// 科室id
	private Integer cityId; // 城市id
	private Integer paramterId; // 参数id
	private Integer page; // 参数id
	private RoleBean roleBean; // 角色实体
	private OfficeBean officeBean; // 科室实体
	private CityBean cityBean; // 城市实体
	private ParameterBean parameterBean; // 参数实体

	public ManagerBean()
	{
		// TODO Auto-generated constructor stub
	}

	public ManagerBean(Integer adminId, String mangerName, String sex, Integer age, String birthDate, String address,
			Long phoneNum, String password, Integer roleId, Integer officeId, Integer cityId, Integer paramterId,
			RoleBean roleBean, OfficeBean officeBean, CityBean cityBean, ParameterBean parameterBean)
	{
		super();
		this.adminId = adminId;
		this.mangerName = mangerName;
		this.sex = sex;
		this.age = age;
		this.birthDate = birthDate;
		this.address = address;
		this.phoneNum = phoneNum;
		this.password = password;
		this.roleId = roleId;
		this.officeId = officeId;
		this.cityId = cityId;
		this.paramterId = paramterId;
		this.roleBean = roleBean;
		this.officeBean = officeBean;
		this.cityBean = cityBean;
		this.parameterBean = parameterBean;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
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

	public Integer getRoleId()
	{
		return roleId;
	}

	public void setRoleId(Integer roleId)
	{
		this.roleId = roleId;
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

	public RoleBean getRoleBean()
	{
		return roleBean;
	}

	public void setRoleBean(RoleBean roleBean)
	{
		this.roleBean = roleBean;
	}

	public OfficeBean getOfficeBean()
	{
		return officeBean;
	}

	public void setOfficeBean(OfficeBean officeBean)
	{
		this.officeBean = officeBean;
	}

	public CityBean getCityBean()
	{
		return cityBean;
	}

	public void setCityBean(CityBean cityBean)
	{
		this.cityBean = cityBean;
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
