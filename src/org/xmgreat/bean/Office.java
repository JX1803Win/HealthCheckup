package org.xmgreat.bean;

public class Office
{
	private Integer officeId; // 科室id
	private String officeName; // 科室名称

	public Office()
	{
		super();
	}

	public Office(Integer officeId, String officeName)
	{
		super();
		this.officeId = officeId;
		this.officeName = officeName;
	}

	public Integer getOfficeId()
	{
		return officeId;
	}

	public void setOfficeId(Integer officeId)
	{
		this.officeId = officeId;
	}

	public String getOfficeName()
	{
		return officeName;
	}

	public void setOfficeName(String officeName)
	{
		this.officeName = officeName;
	}

}
