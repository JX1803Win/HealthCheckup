package org.xmgreat.bean;

import org.springframework.stereotype.Component;

@Component
public class ProjectResultBean //用户项目结果表 
{
	private Integer resultId;//结果ID
	private Integer physicaiId;//体检号ID
	private Integer projectId;//项目ID
	private Integer adminId;//管理员ID
	private String projectResult;//项目结果
	private Integer parameterId;//参数ID
	private String userName;//用户名
	private String projectName;//项目名
	private String parameterName;//参数名
	public ProjectResultBean() {
		super();
	}
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getParameterName() {
		return parameterName;
	}

	public void setParameterName(String parameterName) {
		this.parameterName = parameterName;
	}

	public void setResultId(Integer resultId) {
		this.resultId = resultId;
	}

	public Integer getResultId() {
		return resultId;
	}
	public void setResultID(Integer resultId) {
		this.resultId = resultId;
	}
	public Integer getPhysicaiId() {
		return physicaiId;
	}
	public void setPhysicaiId(Integer physicaiId) {
		this.physicaiId = physicaiId;
	}
	public Integer getProjectId() {
		return projectId;
	}
	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}
	public Integer getAdminId() {
		return adminId;
	}
	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}
	public String getProjectResult() {
		return projectResult;
	}
	public void setProjectResult(String projectResult) {
		this.projectResult = projectResult;
	}
	public Integer getParameterId() {
		return parameterId;
	}
	public void setParameterId(Integer parameterId) {
		this.parameterId = parameterId;
	}
	
}
