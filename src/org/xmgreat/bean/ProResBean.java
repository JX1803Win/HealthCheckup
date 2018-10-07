package org.xmgreat.bean;

import org.springframework.stereotype.Component;

/**
 * @author 宋卓伟
 * @date 2018年9月29日
 * @description 项目结果bean
 */

@Component
public class ProResBean {
	private Integer proresId;// 项目结果id
	private Long physicaiId;//体检号ID
	private Integer projectId;//项目ID
	private String itemName;//项目名称
	private Integer adminId;//管理员ID
	private String managerName;//管理员姓名
	private String projectResult;//项目结果
	private Integer parameterId;//参数ID
	private String parameterName;//参数名称
	
	public ProResBean() {
		
	}

	public Integer getProresId() {
		return proresId;
	}

	public void setProresId(Integer proresId) {
		this.proresId = proresId;
	}

	public Long getPhysicaiId() {
		return physicaiId;
	}

	public void setPhysicaiId(Long physicaiId) {
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

	public String getManagerName() {
		return managerName;
	}

	public void setMangerName(String managerName) {
		this.managerName = managerName;
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

	public String getParameterName() {
		return parameterName;
	}

	public void setParameterName(String parameterName) {
		this.parameterName = parameterName;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	
}
