package org.xmgreat.bean;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class ProjectResultBean // 用户项目结果表
{
	private Integer proresId;// 结果ID
	private Integer physicaiId;// 体检号ID
	private Integer projectId;// 项目ID
	private Integer adminId;// 管理员ID
	private String projectResult;// 项目结果
	private Integer parameterId;// 参数ID
	private String userName;// 用户名
	private String projectName;// 项目名
	private String parameterName;// 参数名
	private List<SubentryBean> subentrys; // 细项结果集合
	private ProjectBean projectBean; // 项目实体

	public ProjectResultBean()
	{
		super();
	}

	public ProjectResultBean(Integer proresId, Integer parameterId)
	{
		super();
		this.proresId = proresId;
		this.parameterId = parameterId;
	}

	public ProjectResultBean(Integer proresId, String projectResult, Integer parameterId)
	{
		super();
		this.proresId = proresId;
		this.projectResult = projectResult;
		this.parameterId = parameterId;
	}

	public ProjectResultBean(Integer proresId, Integer physicaiId, Integer projectId, Integer adminId,
			String projectResult, Integer parameterId, String userName, String projectName, String parameterName,
			List<SubentryBean> subentrys, ProjectBean projectBean)
	{
		super();
		this.proresId = proresId;
		this.physicaiId = physicaiId;
		this.projectId = projectId;
		this.adminId = adminId;
		this.projectResult = projectResult;
		this.parameterId = parameterId;
		this.userName = userName;
		this.projectName = projectName;
		this.parameterName = parameterName;
		this.subentrys = subentrys;
		this.projectBean = projectBean;
	}

	public ProjectBean getProjectBean()
	{
		return projectBean;
	}

	public void setProjectBean(ProjectBean projectBean)
	{
		this.projectBean = projectBean;
	}

	public List<SubentryBean> getSubentrys()
	{
		return subentrys;
	}

	public void setSubentrys(List<SubentryBean> subentrys)
	{
		this.subentrys = subentrys;
	}

	public String getUserName()
	{
		return userName;
	}

	public void setUserName(String userName)
	{
		this.userName = userName;
	}

	public String getProjectName()
	{
		return projectName;
	}

	public void setProjectName(String projectName)
	{
		this.projectName = projectName;
	}

	public String getParameterName()
	{
		return parameterName;
	}

	public void setParameterName(String parameterName)
	{
		this.parameterName = parameterName;
	}

	public Integer getProresId()
	{
		return proresId;
	}

	public void setProresId(Integer proresId)
	{
		this.proresId = proresId;
	}

	public Integer getPhysicaiId()
	{
		return physicaiId;
	}

	public void setPhysicaiId(Integer physicaiId)
	{
		this.physicaiId = physicaiId;
	}

	public Integer getProjectId()
	{
		return projectId;
	}

	public void setProjectId(Integer projectId)
	{
		this.projectId = projectId;
	}

	public Integer getAdminId()
	{
		return adminId;
	}

	public void setAdminId(Integer adminId)
	{
		this.adminId = adminId;
	}

	public String getProjectResult()
	{
		return projectResult;
	}

	public void setProjectResult(String projectResult)
	{
		this.projectResult = projectResult;
	}

	public Integer getParameterId()
	{
		return parameterId;
	}

	public void setParameterId(Integer parameterId)
	{
		this.parameterId = parameterId;
	}

}
