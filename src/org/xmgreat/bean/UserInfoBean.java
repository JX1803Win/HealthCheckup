package org.xmgreat.bean;

public class UserInfoBean	 //用户信息
{
	private Integer userId;  // 用户ID
	private String userName; //用户名字
	private String sex;		 //性别
	private Integer age;	 //年龄
	private String birth;	 //出生日期
	private String bloodType;//血型
	private Integer cityId;  //城市ID
	private String useradd;		 //地址
	private Long phone;		 //手机号
	private String pwd;		 //密码
	private String regTime;  //注册时间
	private Long phyCardId;  //体检卡ID
	private Integer parameterID; //参数ID
	
	public UserInfoBean() {
		
	}

	public Integer getUserId()
	{
		return userId;
	}

	public void setUserId(Integer userId)
	{
		this.userId = userId;
	}

	public String getUserName()
	{
		return userName;
	}

	public void setUserName(String userName)
	{
		this.userName = userName;
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

	public String getBirth()
	{
		return birth;
	}

	public void setBirth(String birth)
	{
		this.birth = birth;
	}

	public String getBloodType()
	{
		return bloodType;
	}

	public void setBloodType(String bloodType)
	{
		this.bloodType = bloodType;
	}

	public Integer getCityId()
	{
		return cityId;
	}

	public void setCityId(Integer cityId)
	{
		this.cityId = cityId;
	}

	public String getUseradd()
	{
		return useradd;
	}

	public void setUseradd(String useradd)
	{
		this.useradd = useradd;
	}

	public Long getPhone()
	{
		return phone;
	}

	public void setPhone(Long phone)
	{
		this.phone = phone;
	}

	public String getPwd()
	{
		return pwd;
	}

	public void setPwd(String pwd)
	{
		this.pwd = pwd;
	}

	public String getRegTime()
	{
		return regTime;
	}

	public void setRegTime(String regTime)
	{
		this.regTime = regTime;
	}

	public Long getphyCardId()
	{
		return phyCardId;
	}

	public void setphyCardId(Long phyCardId)
	{
		this.phyCardId = phyCardId;
	}

	public Integer getParameterID()
	{
		return parameterID;
	}

	public void setParameterID(Integer parameterID)
	{
		this.parameterID = parameterID;
	}

}
