package org.xmgreat.mapper;

import java.util.List;

import org.xmgreat.bean.DetailBean;

public interface DetailMapper
{
	public List<DetailBean> getDetails(String detailName);
}
