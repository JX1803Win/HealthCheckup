package org.xmgreat.bean;

public class PhyCardBean // 体检卡
{
	private Long PhyCardId; // 体检卡ID
	private Integer parameterId; // 参数ID

	public PhyCardBean() {
		
	}

	public Long getPhyCardId()
	{
		return PhyCardId;
	}

	public void setPhyCardId(Long phyCardId)
	{
		PhyCardId = phyCardId;
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
