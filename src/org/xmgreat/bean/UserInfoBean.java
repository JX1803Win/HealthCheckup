package org.xmgreat.bean;

import org.springframework.stereotype.Component;

@Component
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
	private String regTimeA;  //注册时间
	private String regTimeB;  //注册时间
	private Long phyCardId;  //体检卡ID
	private String phyCardId1;  //体检卡ID
	private Integer parameterID; //参数ID
	private String parameterID1; //参数ID
	private Integer page;  //页数
	private ParameterBean parameterBean;
	public UserInfoBean() {
		
	}

	public String getParameterID1() {
		return parameterID1;
	}

	public void setParameterID1(String parameterID1) {
		this.parameterID1 = parameterID1;
	}

	public String getPhyCardId1() {
		return phyCardId1;
	}

	public void setPhyCardId1(String phyCardId1) {
		this.phyCardId1 = phyCardId1;
	}

	public Long getPhyCardId() {
		return phyCardId;
	}

	public void setPhyCardId(Long phyCardId) {
		this.phyCardId = phyCardId;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
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

	public Integer getParameterID()
	{
		return parameterID;
	}

	public void setParameterID(Integer parameterID)
	{
		this.parameterID = parameterID;
	}

	public String getRegTimeA() {
		return regTimeA;
	}

	public void setRegTimeA(String regTimeA) {
		this.regTimeA = regTimeA;
	}

	public String getRegTimeB() {
		return regTimeB;
	}

	public void setRegTimeB(String regTimeB) {
		this.regTimeB = regTimeB;
	}

	public ParameterBean getParameterBean() {
		return parameterBean;
	}

	public void setParameterBean(ParameterBean parameterBean) {
		this.parameterBean = parameterBean;
	}

}
