package org.xmgreat.bean;

import org.springframework.stereotype.Component;

@Component
public class SubentryBean// 用户细项结果表
{
	private Integer resultId;// 细项结果id
	private Integer subentryId;// 细项ID
	private String result;// 结果
	private String hint;// 提示
	private Integer proresId; // 项目结果id
	private Long barcode;// 条码号
	private DetailBean detail;// 细项实体
	private DetailBean detailBean;

	public SubentryBean()
	{
		super();
	}

	public SubentryBean(Integer resultId, Integer subentryId, String result, String hint, Integer proresId,
			Long barcode, DetailBean detail)
	{
		super();
		this.resultId = resultId;
		this.subentryId = subentryId;
		this.result = result;
		this.hint = hint;
		this.proresId = proresId;
		this.barcode = barcode;
		this.detail = detail;
	}

	public Integer getSubentryId()
	{
		return subentryId;
	}

	public void setSubentryId(Integer subentryId)
	{
		this.subentryId = subentryId;
	}

	public String getResult()
	{
		return result;
	}

	public void setResult(String result)
	{
		this.result = result;
	}

	public String getHint()
	{
		return hint;
	}

	public void setHint(String hint)
	{
		this.hint = hint;
	}

	public DetailBean getDetail()
	{
		return detail;
	}

	public void setDetail(DetailBean detail)
	{
		this.detail = detail;
	}

	public Integer getResultId()
	{
		return resultId;
	}

	public void setResultId(Integer resultId)
	{
		this.resultId = resultId;
	}

	public Integer getProresId()
	{
		return proresId;
	}

	public void setProresId(Integer proresId)
	{
		this.proresId = proresId;
	}

	public Long getBarcode()
	{
		return barcode;
	}

	public void setBarcode(Long barcode)
	{
		this.barcode = barcode;
	}

	public DetailBean getDetailBean() {
		return detailBean;
	}

	public void setDetailBean(DetailBean detailBean) {
		this.detailBean = detailBean;
	}

}
