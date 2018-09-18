package org.xmgreat.bean;

public class UserPhyRecordBean //用户体检记录
{
	private Integer physicaiId;//体检号
	private Long barCode;	   //条码号
	private Integer userId;	   //用户ID
	private Integer setmealId; //套餐ID
	private Integer projectId; //项目ID
	private String phyTime;    //体检时间
	private String phyConad;   //体检总结及建议
	private String guidance;   //生活保健指导
	private Integer adminId;   //总结医生ID
	private String sumTime;    //总结时间
	
	public UserPhyRecordBean() {
		
	}

	public Integer getPhysicaiId()
	{
		return physicaiId;
	}

	public void setPhysicaiId(Integer physicaiId)
	{
		this.physicaiId = physicaiId;
	}

	public Long getBarCode()
	{
		return barCode;
	}

	public void setBarCode(Long barCode)
	{
		this.barCode = barCode;
	}

	public Integer getUserId()
	{
		return userId;
	}

	public void setUserId(Integer userId)
	{
		this.userId = userId;
	}

	public Integer getSetmealId()
	{
		return setmealId;
	}

	public void setSetmealId(Integer setmealId)
	{
		this.setmealId = setmealId;
	}

	public Integer getProjectId()
	{
		return projectId;
	}

	public void setProjectId(Integer projectId)
	{
		this.projectId = projectId;
	}

	public String getPhyTime()
	{
		return phyTime;
	}

	public void setPhyTime(String phyTime)
	{
		this.phyTime = phyTime;
	}

	public String getPhyConad()
	{
		return phyConad;
	}

	public void setPhyConad(String phyConad)
	{
		this.phyConad = phyConad;
	}

	public String getGuidance()
	{
		return guidance;
	}

	public void setGuidance(String guidance)
	{
		this.guidance = guidance;
	}

	public Integer getAdminId()
	{
		return adminId;
	}

	public void setAdminId(Integer adminId)
	{
		this.adminId = adminId;
	}

	public String getSumTime()
	{
		return sumTime;
	}

	public void setSumTime(String sumTime)
	{
		this.sumTime = sumTime;
	}
	
}
