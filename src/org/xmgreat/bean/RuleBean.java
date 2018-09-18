package org.xmgreat.bean;

import org.springframework.stereotype.Repository;

@Repository
public class RuleBean {//角色表
      private Integer ruleId;//角色ID
      private String ruleName;//角色名
      public RuleBean() {
		// TODO Auto-generated constructor stub
	}
	public RuleBean(Integer ruleId, String ruleName) {
		super();
		this.ruleId = ruleId;
		this.ruleName = ruleName;
	}
	public Integer getRuleId() {
		return ruleId;
	}
	public void setRuleId(Integer ruleId) {
		this.ruleId = ruleId;
	}
	public String getRuleName() {
		return ruleName;
	}
	public void setRuleName(String ruleName) {
		this.ruleName = ruleName;
	}
      
}
