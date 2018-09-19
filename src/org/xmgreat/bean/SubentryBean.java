package org.xmgreat.bean;

public class SubentryBean//用户细项结果表
{
	private Integer id;//ID
	private Integer physicaiId;//体检号ID
	private Integer projectId;//项目ID
	private Integer subentryId;//细项ID
	private String result;//结果
	private String hint;//提示
	public SubentryBean() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public Integer getSubentryId() {
		return subentryId;
	}
	public void setSubentryId(Integer subentryId) {
		this.subentryId = subentryId;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getHint() {
		return hint;
	}
	public void setHint(String hint) {
		this.hint = hint;
	}

}
