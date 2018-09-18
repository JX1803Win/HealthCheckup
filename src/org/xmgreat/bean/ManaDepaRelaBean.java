package org.xmgreat.bean;

import java.util.List;

import org.springframework.stereotype.Repository;
@Repository
public class ManaDepaRelaBean {//管理员科室关系表
     private Integer officeId;//科室ID
     private List<ManagerBean> mbList;
     public ManaDepaRelaBean() {
		// TODO Auto-generated constructor stub
	}
	public Integer getOfficeId() {
		return officeId;
	}
	public void setOfficeId(Integer officeId) {
		this.officeId = officeId;
	}
	public List<ManagerBean> getMbList() {
		return mbList;
	}
	public void setMbList(List<ManagerBean> mbList) {
		this.mbList = mbList;
	}
     
}
