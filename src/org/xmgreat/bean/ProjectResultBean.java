package org.xmgreat.bean;

public class ProjectResultBean //用户项目结果表 
{
	private Integer resultId;//结果ID
	private Integer physicaiId;//体检号ID
	private Integer projectId;//项目ID
	private Integer adminId;//管理员ID
	private String projectResult;//项目结果
	private Integer parameterId;//参数ID
	
	
	public ProjectResultBean() {
		super();
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
