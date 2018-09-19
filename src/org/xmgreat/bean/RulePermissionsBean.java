package org.xmgreat.bean;

import java.util.List;

public class RulePermissionsBean {
      private Integer ruleId;
      private List<PermissionsInfBean> pibList;//角色权限
      public RulePermissionsBean() {
		// TODO Auto-generated constructor stub
	}
	public Integer getRuleId() {
		return ruleId;
	}
	public void setRuleId(Integer ruleId) {
		this.ruleId = ruleId;
	}
	public List<PermissionsInfBean> getPibList() {
		return pibList;
	}
	public void setPibList(List<PermissionsInfBean> pibList) {
		this.pibList = pibList;
	}
      
}
