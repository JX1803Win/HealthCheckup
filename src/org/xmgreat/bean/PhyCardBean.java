package org.xmgreat.bean;

import org.springframework.stereotype.Component;

@Component
public class PhyCardBean // 体检卡
{
	private Long phyCardId; // 体检卡ID
	private Integer parameterId; // 参数ID

	public PhyCardBean() {
		
	}

	public Long getPhyCardId()
	{
		return phyCardId;
	}

	public void setPhyCardId(Long phyCardId)
	{
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
