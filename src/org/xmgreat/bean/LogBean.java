package org.xmgreat.bean;

public class LogBean //日志表
{
	private Integer logId; //日志ID
	private ManagerBean managerBean;//管理员bean
	private String matter; //事项
	private String operTime; //操作时间1

	public LogBean() {
		
	}

	public Integer getLogId()
	{
		return logId;
	}

	public void setLogId(Integer logId)
	{
		this.logId = logId;
	}

	public ManagerBean getManagerBean()
	{
		return managerBean;
	}

	public void setManagerBean(ManagerBean managerBean)
	{
		this.managerBean = managerBean;
	}

	public String getMatter()
	{
		return matter;
	}

	public void setMatter(String matter)
	{
		this.matter = matter;
	}

	public String getOperTime()
	{
		return operTime;
	}

	public void setOperTime(String operTime)
	{
		this.operTime = operTime;
	}
	
}
