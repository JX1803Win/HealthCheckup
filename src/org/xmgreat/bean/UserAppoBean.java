package org.xmgreat.bean;

public class UserAppoBean	//用户预约表
{
	private Integer appoId; //预约ID
	private String appoTime;//预约时间
	private Integer physicaiId;//体检号

	public UserAppoBean() {
		
	}

	public Integer getAppoId()
	{
		return appoId;
	}

	public void setAppoId(Integer appoId)
	{
		this.appoId = appoId;
	}

	public String getAppoTime()
	{
		return appoTime;
	}

	public void setAppoTime(String appoTime)
	{
		this.appoTime = appoTime;
	}

	public Integer getPhysicaiId()
	{
		return physicaiId;
	}

	public void setPhysicaiId(Integer physicaiId)
	{
		this.physicaiId = physicaiId;
	}
	
}
