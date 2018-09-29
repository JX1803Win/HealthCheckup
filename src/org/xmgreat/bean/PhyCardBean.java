package org.xmgreat.bean;

import org.springframework.stereotype.Component;

@Component
public class PhyCardBean // 体检卡
{
	private Long phyCardId; // 体检卡ID
	private Integer parameterId; // 参数ID
	private Integer page; // 当前页数
	private ParameterBean parameterBean;
	private String phyCardId1; // 体检卡ID
	private String parameterId1; // 参数ID
	public PhyCardBean() {
		
	}

	

	public PhyCardBean(Long phyCardId, Integer parameterId) {
		super();
		this.phyCardId = phyCardId;
		this.parameterId = parameterId;
	}



	public ParameterBean getParameterBean() {
		return parameterBean;
	}



	public void setParameterBean(ParameterBean parameterBean) {
		this.parameterBean = parameterBean;
	}



	public String getPhyCardId1() {
		return phyCardId1;
	}



	public void setPhyCardId1(String phyCardId1) {
		this.phyCardId1 = phyCardId1;
	}



	public String getParameterId1() {
		return parameterId1;
	}



	public void setParameterId1(String parameterId1) {
		this.parameterId1 = parameterId1;
	}



	public Integer getPage() {
		return page;
	}



	public void setPage(Integer page) {
		this.page = page;
	}



	public Long getPhyCardId() {
		return phyCardId;
	}



	public void setPhyCardId(Long phyCardId) {
		this.phyCardId = phyCardId;
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
