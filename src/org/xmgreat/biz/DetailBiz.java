package org.xmgreat.biz;

import java.util.List;

import org.xmgreat.bean.DetailBean;
import org.xmgreat.bean.ParameterBean;

public interface DetailBiz
{
	public List<DetailBean> getDetails(String detailName);

	public List<ParameterBean> getUnits();

}
