package org.xmgreat.bean;

import org.springframework.stereotype.Component;

@Component
public class LogBean
{
	private Integer logId;
	private Integer adminId; // 管理员id
	private String module; // 执行的模块
	private String method; // 执行的方法
	private String rsponseDate; // 响应时间
	private String ip; // IP地址
	private String executionDate; // 执行时间
	private String commite; // 执行描述
	private ManagerBean managerBean;

	public LogBean()
	{
		super();
	}

	public Integer getLogId()
	{
		return logId;
	}

	public void setLogId(Integer logId)
	{
		this.logId = logId;
	}

	public Integer getAdminId()
	{
		return adminId;
	}

	public void setAdminId(Integer adminId)
	{
		this.adminId = adminId;
	}

	public String getModule()
	{
		return module;
	}

	public void setModule(String module)
	{
		this.module = module;
	}

	public String getMethod()
	{
		return method;
	}

	public void setMethod(String method)
	{
		this.method = method;
	}

	public String getRsponseDate()
	{
		return rsponseDate;
	}

	public void setRsponseDate(String rsponseDate)
	{
		this.rsponseDate = rsponseDate;
	}

	public String getIp()
	{
		return ip;
	}

	public void setIp(String ip)
	{
		this.ip = ip;
	}

	public String getExecutionDate()
	{
		return executionDate;
	}

	public void setExecutionDate(String executionDate)
	{
		this.executionDate = executionDate;
	}

	public String getCommite()
	{
		return commite;
	}

	public void setCommite(String commite)
	{
		this.commite = commite;
	}

	public ManagerBean getManagerBean()
	{
		return managerBean;
	}

	public void setManagerBean(ManagerBean managerBean)
	{
		this.managerBean = managerBean;
	}

}
